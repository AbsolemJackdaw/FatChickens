package jackdaw.fatchicken.entity;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.registry.FatChickenEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TableCloth extends HangingEntity {

    public TableCloth(EntityType<TableCloth> type, Level level) {
        super(type, level);
    }

    public static TableCloth create(EntityType<TableCloth> type, Level level) {
        return new TableCloth(type, level);
    }

    public TableCloth(Level level, BlockPos pos, Direction dir) {
        this(FatChickenEntities.CLOTHTYPE, level, pos, dir);
    }

    public TableCloth(EntityType<TableCloth> type, Level level, BlockPos pos, Direction dir) {
        super(type, level, pos);
        this.setDirection(dir);
    }

    @Override
    protected void setDirection(@NotNull Direction direction) {
        Validate.notNull(direction);
        this.direction = direction;
        if (direction.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float) (this.direction.get2DDataValue() * 90));
        } else {
            this.setXRot((float) (-90 * direction.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    @Override
    protected AABB calculateBoundingBox(BlockPos blockPos, Direction direction) {
        if (direction == null) //direction will be null at init
            return AABB.of(BoundingBox.infinite());
        double scale = 0.46875D;
        double x = (double) this.pos.getX() + 0.5D - (double) this.direction.getStepX() * scale;
        double y = (double) this.pos.getY() + 0.5D - (double) this.direction.getStepY() * scale;
        double z = (double) this.pos.getZ() + 0.5D - (double) this.direction.getStepZ() * scale;
        this.setPosRaw(x, y, z);
        double width = 16;
        double height = 16;
        double depth = 16;
        Direction.Axis direction$axis = this.direction.getAxis();
        switch (direction$axis) {
            case X -> width = 1.0D;
            case Y -> height = 1.0D;
            case Z -> depth = 1.0D;
        }

        width /= 32.0D;
        height /= 32.0D;
        depth /= 32.0D;
        return new AABB(x - width, y - height, z - depth, x + width, y + height, z + depth);
    }

    @Override
    public boolean survives() {
        if (!this.level().noCollision(this)) {
            return false;
        } else {
            BlockState blockstate = this.level().getBlockState(this.pos.relative(this.direction.getOpposite()));
            return (blockstate.isSolid() || this.direction.getAxis().isHorizontal() && DiodeBlock.isDiode(blockstate)) && this.level().getEntities(this, this.getBoundingBox(), HANGING_ENTITY).isEmpty();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_31808_) {
        super.addAdditionalSaveData(p_31808_);
        p_31808_.putByte("Facing", (byte) this.direction.get3DDataValue());
        p_31808_.putBoolean("Invisible", this.isInvisible());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDirection(Direction.from3DDataValue(tag.getByte("Facing")));
        this.setInvisible(tag.getBoolean("Invisible"));
    }

    @Override
    public void dropItem(@Nullable Entity entity) {
        if (!level().isClientSide) {
            BlockPos pos = this.getPos();
            level().addFreshEntity(new ItemEntity(level(), pos.getX(), pos.getY(), pos.getZ(), new ItemStack(CommonMod.Items.TABLE_CLOTH_ITEM)));
            this.playSound(this.getBreakSound(), 1.0F, 1.0F);
        }
    }

    @Override
    public void playPlacementSound() {
        this.playSound(this.getPlaceSound(), 1.0F, 1.0F);
    }

    public SoundEvent getPlaceSound() {
        return SoundEvents.WOOL_PLACE;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    public boolean shouldRenderAtSqrDistance(double dist) {
        double d0 = 16.0D;
        d0 *= 64.0D * getViewScale();
        return dist < d0 * d0;
    }

    public float getPickRadius() {
        return 0.0F;
    }

    @Override
    public boolean isAttackable() {
        return true;
    }

    protected float getEyeHeight(@NotNull Pose pose, @NotNull EntityDimensions entityDimensions) {
        return 0.0F;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity entity) {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    @Override
    public void recreateFromPacket(@NotNull ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.setDirection(Direction.from3DDataValue(packet.getData()));
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(CommonMod.Items.TABLE_CLOTH_ITEM);
    }

    public SoundEvent getBreakSound() {
        return SoundEvents.WOOL_BREAK;
    }
}