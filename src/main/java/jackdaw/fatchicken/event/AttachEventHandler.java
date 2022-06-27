package jackdaw.fatchicken.event;

import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.capability.FatCap;
import jackdaw.fatchicken.tag.Fatties;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttachEventHandler {

    @SubscribeEvent
    public static void onAttach(AttachCapabilitiesEvent<Entity> event) {
        if (Fatties.hasFatCap(event.getObject().getType())) {
            event.addCapability(FatCap.KEY, new FatCap());
        }
    }
}
