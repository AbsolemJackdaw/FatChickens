package jackdaw.fatchicken.items;

import jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class TableClothItem extends HangingEntityItem {
    public TableClothItem(EntityType<? extends HangingEntity> type, Properties properties) {
        super(type, properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos blockpos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        Player player = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        if (player != null && !this.mayPlace(player, direction, itemstack, blockpos1)) {
            return InteractionResult.FAIL;
        } else {
            Level level = context.getLevel();
            TableCloth cloth = new TableCloth(level, blockpos1, direction);

            CompoundTag compoundtag = itemstack.getTag();
            if (compoundtag != null) {
                EntityType.updateCustomEntityTag(level, player, cloth, compoundtag);
            }

            if (cloth.survives()) {
                if (!level.isClientSide) {
                    cloth.playPlacementSound();
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, blockpos);
                    level.addFreshEntity(cloth);
                }

                itemstack.shrink(1);
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.CONSUME;
            }
        }
    }

    @Override
    protected boolean mayPlace(Player player, Direction dir, ItemStack stack, BlockPos pos) {
        return !player.level.isOutsideBuildHeight(pos) && player.mayUseItemAt(pos, dir, stack);
    }
}
