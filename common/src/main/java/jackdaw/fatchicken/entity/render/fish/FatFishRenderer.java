package jackdaw.fatchicken.entity.render.fish;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatFish;
import net.minecraft.client.model.SalmonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FatFishRenderer extends MobRenderer<FatFish, SalmonModel<FatFish>> {
    private static final ResourceLocation FISH_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/fish/salmon.png");

    public FatFishRenderer(EntityRendererProvider.Context context) {
        super(context, new SalmonModel<>(context.bakeLayer(CommonMod.Models.FATFISH)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(FatFish chicken) {
        return FISH_LOCATION;
    }

    @Override
    protected void setupRotations(FatFish fatfish, PoseStack stack, float bob, float yBodyRot, float partialTick, float scale) {
        super.setupRotations(fatfish, stack, bob, yBodyRot, partialTick, scale);
        float f = 1.0F;
        float f1 = 1.0F;
        if (!fatfish.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * bob);
        stack.mulPose(Axis.YP.rotationDegrees(f2));
        stack.translate(0.0D, 0.0D, -0.4F);
        if (!fatfish.isInWater()) {
            stack.translate(0.2F, 0.1F, 0.0D);
            stack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }
}