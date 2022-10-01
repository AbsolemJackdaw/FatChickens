package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CommonMod.MODID, bus = Bus.MOD)
public class ModelLoadingEvent {

    @SubscribeEvent
    public static void registerItemModel(ModelEvent.RegisterAdditional event) {
        event.register(CommonMod.Models.TABLECLOTH);
    }
}
