package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.registry.FatChickenEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CommonMod.ID)
public class EntityAttributeEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, CommonMod.MobAttributes.CHICKEN.build());
        event.put(FatChickenEntities.FAT_PIG_ENTITY_TYPE, CommonMod.MobAttributes.PIG.build());
        event.put(FatChickenEntities.FAT_FISH_ENTITY_TYPE, CommonMod.MobAttributes.FISH.build());
    }
}


