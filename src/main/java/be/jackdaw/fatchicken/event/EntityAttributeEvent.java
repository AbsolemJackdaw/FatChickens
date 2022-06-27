package be.jackdaw.fatchicken.event;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.FAT_CHICKEN.get(), Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.10D).build());
        event.put(EntityRegistry.FAT_PIG.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.MOVEMENT_SPEED, 0.10D).build());
        event.put(EntityRegistry.FAT_FISH.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.15D).build());

    }
}


