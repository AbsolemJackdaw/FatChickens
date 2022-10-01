package jackdaw.fatchicken.entity.render.pig;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatPig;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FatPigRenderer extends MobRenderer<FatPig, FatPigModel<FatPig>> {
    private static final ResourceLocation PIG_LOCATION = new ResourceLocation("textures/entity/pig/pig.png");

    public FatPigRenderer(EntityRendererProvider.Context context) {
        super(context, new FatPigModel<>(context.bakeLayer(CommonMod.Models.FATPIG)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(FatPig chicken) {
        return PIG_LOCATION;
    }

}