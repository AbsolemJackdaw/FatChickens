package jackdaw.fatchicken.events;

import jackdaw.fatchicken.FatAnimalRegistry;
import jackdaw.fatchicken.capability.FabricFat;
import jackdaw.fatchicken.tag.Fatties;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

import java.util.Random;

public class FeedAnimalsEvent {
    private static final Random rand = new Random();

    public static void register() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (player.getItemInHand(hand).getItem().equals(Items.SWEET_BERRIES)) {
                if (Fatties.hasFatCap(entity.getType())) {
                    if (entity instanceof LivingEntity living && FabricFat.get(living).isPresent())
                        FabricFat.get(living).ifPresent(data -> {
                            if (player.level.isClientSide) {
                                for (int i = 0; i < 3; i++)
                                    player.level.addParticle(ParticleTypes.HAPPY_VILLAGER, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), rand.nextDouble() / 100d, rand.nextDouble() / 100d, rand.nextDouble() / 100d);
                            } else {
                                data.feed();
                                player.swing(hand);
                                if (!player.isCreative())
                                    player.getItemInHand(hand).shrink(1);

                                if (data.isFat()) {
                                    LivingEntity fatAnimal = FatAnimalRegistry.getFattyFromSkinny(entity.getType(), player.level);
                                    fatAnimal.setPos(living.position());
                                    fatAnimal.setYRot(living.getYRot());
                                    fatAnimal.setXRot(living.getXRot());
                                    living.remove(Entity.RemovalReason.DISCARDED);
                                    player.level.addFreshEntity(fatAnimal);
                                }
                            }
                        });
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.FAIL;
        });
    }
}
