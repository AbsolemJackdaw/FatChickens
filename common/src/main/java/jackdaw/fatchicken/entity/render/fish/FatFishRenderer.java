package jackdaw.fatchicken.entity.render.fish;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatFish;
import net.minecraft.client.model.animal.fish.SalmonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SalmonRenderState;
import net.minecraft.resources.Identifier;

public class FatFishRenderer extends MobRenderer<FatFish, FatFishRenderer.FatFishRenderState, SalmonModel> {
    private static final Identifier FISH_LOCATION = Identifier.withDefaultNamespace("textures/entity/fish/salmon.png");

    public FatFishRenderer(EntityRendererProvider.Context context) {
        super(context, new SalmonModel(context.bakeLayer(CommonMod.Models.FISH)), 0.5F);
    }

    @Override
    public FatFishRenderState createRenderState() {
        return new FatFishRenderState();
    }

    @Override
    public Identifier getTextureLocation(FatFishRenderState fatFishRenderState) {
        return FISH_LOCATION;
    }

    public static class FatFishRenderState extends SalmonRenderState {

    }

//    @Override
//    protected void setupRotations(FatFish fatfish, PoseStack stack, float bob, float yBodyRot, float partialTick, float scale) {
//        super.setupRotations(fatfish, stack, bob, yBodyRot, partialTick, scale);
//        float f = 1.0F;
//        float f1 = 1.0F;
//        if (!fatfish.isInWater()) {
//            f = 1.3F;
//            f1 = 1.7F;
//        }
//
//        float f2 = f * 4.3F * Mth.sin(f1 * 0.6F * bob);
//        stack.mulPose(Axis.YP.rotationDegrees(f2));
//        stack.translate(0.0D, 0.0D, -0.4F);
//        if (!fatfish.isInWater()) {
//            stack.translate(0.2F, 0.1F, 0.0D);
//            stack.mulPose(Axis.ZP.rotationDegrees(90.0F));
//        }
//    }
}