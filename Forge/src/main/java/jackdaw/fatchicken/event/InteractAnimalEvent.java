package jackdaw.fatchicken.event;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.FatAnimalRegistry;
import jackdaw.fatchicken.capability.ForgeFat;
import jackdaw.fatchicken.tag.Fatties;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = CommonMod.MODID)
public class InteractAnimalEvent {

    private static final Random rand = new Random();

    @SubscribeEvent
    public static void interact(PlayerInteractEvent.EntityInteract event) {

        if (event.getItemStack().getItem().equals(Items.SWEET_BERRIES)) {
            if (Fatties.hasFatCap(event.getTarget().getType())) {
                if (event.getTarget() instanceof LivingEntity living && ForgeFat.get(living).isPresent())
                    ForgeFat.get(living).ifPresent(data -> {
                        if (event.getLevel().isClientSide) {
                            for (int i = 0; i < 3; i++)
                                event.getLevel().addParticle(ParticleTypes.HAPPY_VILLAGER, event.getTarget().getRandomX(1.0D), event.getTarget().getRandomY() + 0.5D, event.getTarget().getRandomZ(1.0D), rand.nextDouble() / 100d, rand.nextDouble() / 100d, rand.nextDouble() / 100d);
                        } else {
                            data.feed();
                            event.getEntity().swing(event.getHand());
                            if (!event.getEntity().isCreative())
                                event.getItemStack().shrink(1);

                            if (data.isFat()) {
                                LivingEntity fatAnimal = FatAnimalRegistry.getFattyFromSkinny(event.getTarget().getType(), event.getLevel());
                                fatAnimal.setPos(living.position());
                                fatAnimal.setYRot(living.getYRot());
                                fatAnimal.setXRot(living.getXRot());
                                living.remove(Entity.RemovalReason.DISCARDED);
                                event.getEntity().level.addFreshEntity(fatAnimal);
                            }
                        }
                    });
            }
        }
    }
}
