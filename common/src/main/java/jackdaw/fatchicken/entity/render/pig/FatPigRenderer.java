package jackdaw.fatchicken.entity.render.pig;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatPig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.PigRenderState;
import net.minecraft.resources.Identifier;

public class FatPigRenderer extends MobRenderer<FatPig, FatPigRenderer.FatPigRenderState, FatPigModel> {
    private static final Identifier PIG_LOCATION = Identifier.withDefaultNamespace("textures/entity/pig/pig.png");

    public FatPigRenderer(EntityRendererProvider.Context context) {
        super(context, new FatPigModel(context.bakeLayer(CommonMod.Models.PIG)), 0.5F);
    }

    @Override
    public FatPigRenderState createRenderState() {
        return new FatPigRenderState();
    }

    @Override
    public Identifier getTextureLocation(FatPigRenderState fatPigRenderState) {
        return PIG_LOCATION;
    }

    public static class FatPigRenderState extends PigRenderState {

    }

}