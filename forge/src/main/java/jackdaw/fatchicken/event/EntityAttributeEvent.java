package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.registry.FatChickenEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CommonMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, CommonMod.MobAttributes.CHICKEN.build());
        event.put(FatChickenEntities.FAT_PIG_ENTITY_TYPE, CommonMod.MobAttributes.PIG.build());
        event.put(FatChickenEntities.FAT_FISH_ENTITY_TYPE, CommonMod.MobAttributes.FISH.build());
    }
}


