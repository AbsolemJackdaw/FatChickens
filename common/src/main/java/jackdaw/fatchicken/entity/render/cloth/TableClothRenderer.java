package jackdaw.fatchicken.entity.render.cloth;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TableClothRenderer extends EntityRenderer<TableCloth, TableClothRenderState> {
    private final ItemStack model;
    private final ItemModelResolver resolver;

    public TableClothRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new ItemStack(Items.STICK);
        var id = Identifier.fromNamespaceAndPath(CommonMod.ID, CommonMod.CLOTH.concat("_model"));
        model.set(DataComponents.ITEM_MODEL, id);
        resolver = context.getItemModelResolver();
    }

    @Override
    public TableClothRenderState createRenderState() {
        return new TableClothRenderState();
    }

    @Override
    public void extractRenderState(TableCloth entity, TableClothRenderState reusedState, float partialTick) {
        super.extractRenderState(entity, reusedState, partialTick);
        resolver.updateForTopItem(reusedState.clothState, this.model, ItemDisplayContext.NONE, entity.level(), null, (int) entity.blockPosition().asLong());
    }

    @Override
    public void submit(TableClothRenderState cloth, PoseStack stack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        super.submit(cloth, stack, nodeCollector, cameraRenderState);
        stack.pushPose();

        Direction direction = cloth.getDirection();
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - Direction.getYRot(cloth.getDirection())));
        try {
            stack.pushPose();
            stack.translate(0D, 0.47d, 0D);
            cloth.clothState.submit(stack, nodeCollector, cloth.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            stack.popPose();
        } catch (NullPointerException e) {
            throw new RuntimeException("No baked model registered to render for the table cloth. report to mod author", e);
        }
        stack.popPose();
    }
}