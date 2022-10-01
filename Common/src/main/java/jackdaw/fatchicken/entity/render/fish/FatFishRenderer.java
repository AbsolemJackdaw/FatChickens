package jackdaw.fatchicken.entity.render.fish;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatFish;
import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FatFishRenderer extends MobRenderer<FatFish, SalmonModel<FatFish>> {
    private static final ResourceLocation FISH_LOCATION = new ResourceLocation("textures/entity/fish/salmon.png");

    public FatFishRenderer(EntityRendererProvider.Context context) {
        super(context, new SalmonModel<>(context.bakeLayer(CommonMod.Models.FATFISH)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(FatFish chicken) {
        return FISH_LOCATION;
    }

    @Override
    protected void setupRotations(FatFish fatfish, PoseStack stack, float x, float y, float z) {
        super.setupRotations(fatfish, stack, x, y, z);
        float f = 1.0F;
        float f1 = 1.0F;
        if (!fatfish.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * x);
        stack.mulPose(Vector3f.YP.rotationDegrees(f2));
        stack.translate(0.0D, 0.0D, -0.4F);
        if (!fatfish.isInWater()) {
            stack.translate(0.2F, 0.1F, 0.0D);
            stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }

    }
}