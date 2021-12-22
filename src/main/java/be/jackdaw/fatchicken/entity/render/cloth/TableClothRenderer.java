package be.jackdaw.fatchicken.entity.render.cloth;

import be.jackdaw.fatchicken.entity.TableCloth;
import be.jackdaw.fatchicken.event.ModelLoadingEvent;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TableClothRenderer<T extends TableCloth> extends EntityRenderer<T> {
    private final Minecraft minecraft = Minecraft.getInstance();

    public TableClothRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(T cloth, float x, float z, PoseStack stack, MultiBufferSource buffer, int totalLight) {
        super.render(cloth, x, z, stack, buffer, totalLight);
        stack.pushPose();

        Direction direction = cloth.getDirection();
        Vec3 vec3 = this.getRenderOffset(cloth, z);
        stack.translate(-vec3.x(), -vec3.y(), -vec3.z());
        stack.translate((double) direction.getStepX() * 0.46875D, (double) direction.getStepY() * 0.46875D, (double) direction.getStepZ() * 0.46875D);
        //stack.mulPose(Vector3f.XP.rotationDegrees(cloth.getXRot()));
        stack.mulPose(Vector3f.YP.rotationDegrees(180.0F - cloth.getYRot()));
        BlockRenderDispatcher blockrenderdispatcher = this.minecraft.getBlockRenderer();
        ModelManager modelmanager = blockrenderdispatcher.getBlockModelShaper().getModelManager();

        stack.pushPose();
        stack.translate(-0.5D, -0.5D, -0.5D);
        blockrenderdispatcher.getModelRenderer().renderModel(stack.last(), buffer.getBuffer(Sheets.cutoutBlockSheet()), (BlockState) null, modelmanager.getModel(ModelLoadingEvent.TABLECLOTH), 1.0F, 1.0F, 1.0F, totalLight, OverlayTexture.NO_OVERLAY);
        stack.popPose();

        stack.popPose();
    }

    public @NotNull Vec3 getRenderOffset(T cloth, float afloat) {
        return new Vec3((double) ((float) cloth.getDirection().getStepX() * 0.3F), -0.25D, (double) ((float) cloth.getDirection().getStepZ() * 0.3F));
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull T cloth) {
        return TextureAtlas.LOCATION_BLOCKS;
    }

    protected boolean shouldShowName(@NotNull T cloth) {
        return false;
    }

}