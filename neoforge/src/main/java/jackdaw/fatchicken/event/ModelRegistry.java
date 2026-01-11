package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CommonMod.ID, value = Dist.CLIENT)
public class ModelRegistry {

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(CommonMod.Models.CHICKEN, FatChickenModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.PIG, FatPigModel::createBodyLayer);
        event.registerLayerDefinition(CommonMod.Models.FISH, FatFishModelLayer::createBodyLayer);

    }
}