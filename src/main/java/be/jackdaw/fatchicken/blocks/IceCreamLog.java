package be.jackdaw.fatchicken.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IceCreamLog extends FoodBlock {

    protected static final VoxelShape AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);
    private static final VoxelShape plate = Shapes.create(new AABB(0.0625 * 2, 0, 0.0625 * 2, 0.0625 * 14, 0.0625, 0.0625 * 14));
    private static final VoxelShape NS = Shapes.create(new AABB(0.0625 * 5.5, 0.0625, 0.0625 * 3, 0.0625 * 10.5, 0.0625 * 5.0d, 0.0625 * 13.0));
    private static final VoxelShape EW = Shapes.create(new AABB(0.0625 * 3, 0.0625, 0.0625 * 5.5, 0.0625 * 13, 0.0625 * 5.0d, 0.0625 * 10.5));
    private static final VoxelShape CAKE_EW = Shapes.or(plate, EW);
    private static final VoxelShape CAKE_NS = Shapes.or(plate, NS);

    public IceCreamLog(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape directionalShape(Direction direction) {
        return switch (direction) {
            case NORTH, SOUTH -> CAKE_NS;
            case EAST, WEST -> CAKE_EW;
            default -> plate;
        };
    }
}
