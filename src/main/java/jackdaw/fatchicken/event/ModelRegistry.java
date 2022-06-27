package jackdaw.fatchicken.event;

import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModelRegistry {

    public static ModelLayerLocation FATCHICKEN = new ModelLayerLocation(new ResourceLocation("fatchicken"), "fatchicken");
    public static ModelLayerLocation FATPIG = new ModelLayerLocation(new ResourceLocation("fatchicken"), "fatpig");
    public static ModelLayerLocation FATFISH = new ModelLayerLocation(new ResourceLocation("fatchicken"), "fatfish");

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(FATCHICKEN, FatChickenModel::createBodyLayer);
        event.registerLayerDefinition(FATPIG, FatPigModel::createBodyLayer);
        event.registerLayerDefinition(FATFISH, FatFishModelLayer::createBodyLayer);

    }
}