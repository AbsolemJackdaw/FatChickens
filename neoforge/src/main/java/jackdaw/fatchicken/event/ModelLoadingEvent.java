package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;

@EventBusSubscriber(modid = CommonMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ModelLoadingEvent {

    @SubscribeEvent
    public static void registerItemModel(ModelEvent.RegisterAdditional event) {
        event.register(CommonMod.Models.TABLECLOTH_MODEL);
    }
}
