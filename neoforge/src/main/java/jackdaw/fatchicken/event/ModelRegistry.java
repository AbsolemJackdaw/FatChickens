package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CommonMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModelRegistry {

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(CommonMod.Models.FATCHICKEN, FatChickenModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.FATPIG, FatPigModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.FATFISH, FatFishModelLayer::createBodyLayer);

    }
}