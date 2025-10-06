package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.FatAnimalRegistry;
import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.tag.Fatties;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = CommonMod.MODID)
public class InteractAnimalEvent {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void interact(PlayerInteractEvent.EntityInteract event) {

        if (event.getItemStack().getItem().equals(Items.SWEET_BERRIES)) {
            if (Fatties.hasFatCap(event.getTarget().getType())) {
                if (event.getTarget() instanceof LivingEntity living) {
                    var cap = living.getData(FatChickenMod.FATTIESDATA);
                    if (event.getLevel().isClientSide) {
                        for (int i = 0; i < 3; i++)
                            event.getLevel().addParticle(ParticleTypes.HAPPY_VILLAGER,
                                    event.getTarget().getRandomX(1.0D),
                                    event.getTarget().getRandomY() + 0.5D,
                                    event.getTarget().getRandomZ(1.0D),
                                    random.nextDouble() / 100d,
                                    random.nextDouble() / 100d,
                                    random.nextDouble() / 100d);
                    } else {
                        cap.feed();
                        event.getEntity().swing(event.getHand());
                        if (!event.getEntity().isCreative())
                            event.getItemStack().shrink(1);

                        if (cap.isFat()) {
                            LivingEntity fatAnimal = FatAnimalRegistry.makeFattyFromSkinny(event.getTarget().getType(), event.getLevel());
                            fatAnimal.setPos(living.position());
                            fatAnimal.setYRot(living.getYRot());
                            fatAnimal.setXRot(living.getXRot());
                            living.remove(Entity.RemovalReason.DISCARDED);
                            event.getEntity().level().addFreshEntity(fatAnimal);
                        }
                    }
                }
            }
        }
    }
}
