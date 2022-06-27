package be.jackdaw.fatchicken.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FishBlock extends FoodBlock {
    private static final VoxelShape plate = Shapes.create(new AABB(0.0625 * 2d, 0.0D, 0.0625d * 2d, 0.0625d * 14d, 0.0625d, 0.0625d * 14d));
    private static final VoxelShape fish_n_s = Shapes.create(new AABB(0.0625 * 5d, 0.0625D, 0.0625d * 3d, 0.0625d * 11d, 0.0625d * 3d, 0.0625d * 13d));
    private static final VoxelShape fish_e_w = Shapes.create(new AABB(0.0625 * 3d, 0.0625D, 0.0625d * 5d, 0.0625d * 13d, 0.0625d * 3d, 0.0625d * 11d));

    public FishBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape directionalShape(Direction direction) {
        return switch (direction) {
            case NORTH, SOUTH -> Shapes.or(plate, fish_n_s);
            case EAST, WEST -> Shapes.or(plate, fish_e_w);
            default -> plate;
        };
    }
}
