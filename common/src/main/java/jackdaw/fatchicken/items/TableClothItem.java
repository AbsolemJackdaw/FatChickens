package jackdaw.fatchicken.items;

import jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class TableClothItem extends Item {
    public TableClothItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos blockpos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        if (player != null && !this.canPlaceAt(player, direction, itemstack, blockpos1)) {
            return InteractionResult.FAIL;
        } else {
            Level level = context.getLevel();
            TableCloth clothEntity = new TableCloth(level, blockpos1, direction);
            EntityType.createDefaultStackConfig(level, itemstack, player).accept(clothEntity);
            if (clothEntity.survives()) {
                if (!level.isClientSide()) {
                    clothEntity.playPlacementSound();
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, clothEntity.position());
                    level.addFreshEntity(clothEntity);
                }

                itemstack.shrink(1);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    protected boolean canPlaceAt(Player player, Direction dir, ItemStack stack, BlockPos pos) {
        return !player.level().isOutsideBuildHeight(pos) && player.mayUseItemAt(pos, dir, stack);
    }
}
