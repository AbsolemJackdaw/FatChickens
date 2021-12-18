package be.jackdaw.fatchicken.event;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.capability.Fat;
import be.jackdaw.fatchicken.entity.FatChicken;
import be.jackdaw.fatchicken.entity.FatPig;
import be.jackdaw.fatchicken.exception.NoSuchTransformationException;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FatChickenMod.MODID)
public class InteractAnimalEvent {

    private static final Random rand = new Random();

    private static Animal getFatAnimal(EntityType<?> skinny, Level level) {
        if (skinny.equals(EntityType.CHICKEN)) {
            return FatChicken.make(level);
        } else if (skinny.equals(EntityType.PIG)) {
            return FatPig.make(level);
        } else throw new NoSuchTransformationException(skinny.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void interact(PlayerInteractEvent.EntityInteract event) {

        if (event.getItemStack().getItem().equals(Items.SWEET_BERRIES)) {
            if (event.getTarget() instanceof Animal animal) {
                Fat.get(animal).ifPresent(data -> {
                    if (event.getWorld().isClientSide) {
                        for (int i = 0; i < 3; i++)
                            event.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, event.getTarget().getRandomX(1.0D), event.getTarget().getRandomY() + 0.5D, event.getTarget().getRandomZ(1.0D), rand.nextDouble() / 100d, rand.nextDouble() / 100d, rand.nextDouble() / 100d);
                    } else {
                        data.feed();
                        event.getPlayer().swing(event.getHand());
                        if (!event.getPlayer().isCreative())
                            event.getItemStack().shrink(1);

                        if (data.isFat()) {
                            Animal fatAnimal = getFatAnimal(event.getTarget().getType(), event.getWorld());
                            fatAnimal.setPos(animal.position());
                            fatAnimal.setYRot(animal.getYRot());
                            fatAnimal.setXRot(animal.getXRot());
                            animal.remove(Entity.RemovalReason.DISCARDED);
                            event.getPlayer().level.addFreshEntity(fatAnimal);
                        }
                    }
                });
            }
        }
    }
}
