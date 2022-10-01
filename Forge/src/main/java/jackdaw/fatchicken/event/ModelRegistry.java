package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CommonMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModelRegistry {

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(CommonMod.Models.FATCHICKEN, FatChickenModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.FATPIG, FatPigModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.FATFISH, FatFishModelLayer::createBodyLayer);

    }
}