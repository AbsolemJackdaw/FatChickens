package jackdaw.fatchicken.event;

import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.capability.Fat;
import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import jackdaw.fatchicken.exception.NoSuchTransformationException;
import jackdaw.fatchicken.tag.Fatties;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = FatChickenMod.MODID)
public class InteractAnimalEvent {

    private static final Random rand = new Random();

    private static LivingEntity getFatLivingEntityInstance(EntityType<?> skinny, Level level) {
        if (skinny.equals(EntityType.CHICKEN)) {
            return FatChicken.make(level);
        } else if (skinny.equals(EntityType.PIG)) {
            return FatPig.make(level);
        } else if (skinny.equals(EntityType.SALMON)) {
            return FatFish.make(level);
        } else throw new NoSuchTransformationException(skinny.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void interact(PlayerInteractEvent.EntityInteract event) {

        if (event.getItemStack().getItem().equals(Items.SWEET_BERRIES)) {
            if (Fatties.hasFatCap(event.getTarget().getType())) {
                if (event.getTarget() instanceof LivingEntity living && Fat.get(living).isPresent())
                    Fat.get(living).ifPresent(data -> {
                        if (event.getWorld().isClientSide) {
                            for (int i = 0; i < 3; i++)
                                event.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER, event.getTarget().getRandomX(1.0D), event.getTarget().getRandomY() + 0.5D, event.getTarget().getRandomZ(1.0D), rand.nextDouble() / 100d, rand.nextDouble() / 100d, rand.nextDouble() / 100d);
                        } else {
                            data.feed();
                            event.getPlayer().swing(event.getHand());
                            if (!event.getPlayer().isCreative())
                                event.getItemStack().shrink(1);

                            if (data.isFat()) {
                                LivingEntity fatAnimal = getFatLivingEntityInstance(event.getTarget().getType(), event.getWorld());
                                fatAnimal.setPos(living.position());
                                fatAnimal.setYRot(living.getYRot());
                                fatAnimal.setXRot(living.getXRot());
                                living.remove(Entity.RemovalReason.DISCARDED);
                                event.getPlayer().level.addFreshEntity(fatAnimal);
                            }
                        }
                    });
            }
        }
    }
}
