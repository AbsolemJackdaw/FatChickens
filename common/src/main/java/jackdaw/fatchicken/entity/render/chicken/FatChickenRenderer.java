package jackdaw.fatchicken.entity.render.chicken;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatChicken;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.ChickenRenderState;
import net.minecraft.resources.Identifier;

public class FatChickenRenderer extends MobRenderer<FatChicken, FatChickenRenderer.FatChickenRenderState, FatChickenModel> {
    private static final Identifier CHICKEN_LOCATION = Identifier.withDefaultNamespace("textures/entity/chicken.png");

    public FatChickenRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new FatChickenModel(p_173952_.bakeLayer(CommonMod.Models.CHICKEN)), 0.3F);
    }

    @Override
    public Identifier getTextureLocation(FatChickenRenderState fatChickenRenderState) {
        return CHICKEN_LOCATION;
    }

    public static class FatChickenRenderState extends ChickenRenderState {

    }

    @Override
    public FatChickenRenderState createRenderState() {
        return new FatChickenRenderState();
    }

//    protected float getBob(FatChicken p_114000_, float p_114001_) {
//        float f = Mth.lerp(p_114001_, p_114000_.oFlap, p_114000_.flap);
//        float f1 = Mth.lerp(p_114001_, p_114000_.oFlapSpeed / 2f, p_114000_.flapSpeed / 2f);
//        return ((Mth.sin(f) + 1.0F) * f1) / 2f;
//    }
}