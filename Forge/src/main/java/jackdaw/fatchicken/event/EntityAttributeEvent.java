package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CommonMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.FAT_CHICKEN.get(), CommonMod.MobAttributes.CHICKEN.build());
        event.put(EntityRegistry.FAT_PIG.get(), CommonMod.MobAttributes.PIG.build());
        event.put(EntityRegistry.FAT_FISH.get(), CommonMod.MobAttributes.FISH.build());
    }
}


