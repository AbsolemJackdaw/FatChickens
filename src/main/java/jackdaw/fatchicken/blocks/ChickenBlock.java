package jackdaw.fatchicken.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChickenBlock extends FoodBlock {
    private static final VoxelShape board = Shapes.create(new AABB(0.0625 * 2d, 0.0D, 0.0625d * 3, 0.0625d * 14, 0.0625d * 1, 0.0625d * 14));

    private static final VoxelShape body_n_s = Shapes.create(new AABB(0.0625 * 4d, 0.0625D, 0.0625d * 3, 0.0625d * 12, 0.0625d * 6, 0.0625d * 13));
    private static final VoxelShape body_e_w = Shapes.create(new AABB(0.0625 * 3d, 0.0625D, 0.0625d * 4, 0.0625d * 13, 0.0625d * 6, 0.0625d * 12));

    private static final VoxelShape leg_r_n = Shapes.create(new AABB(0.0625 * 2, 0.0625 * 2D, 0.0625d * 4, 0.0625d * 4, 0.0625d * 6, 0.0625d * 8));
    private static final VoxelShape leg_r_s = Shapes.create(new AABB(0.0625 * 2, 0.0625 * 2D, 0.0625d * 8, 0.0625d * 4, 0.0625d * 6, 0.0625d * 12));

    private static final VoxelShape leg_l_n = Shapes.create(new AABB(0.0625 * 12, 0.0625 * 2D, 0.0625d * 4, 0.0625d * 14, 0.0625d * 6, 0.0625d * 8));
    private static final VoxelShape leg_l_s = Shapes.create(new AABB(0.0625 * 12, 0.0625 * 2D, 0.0625d * 8, 0.0625d * 14, 0.0625d * 6, 0.0625d * 12));

    private static final VoxelShape leg_r_e = Shapes.create(new AABB(0.0625 * 8, 0.0625 * 2D, 0.0625d * 2, 0.0625d * 12, 0.0625d * 6, 0.0625d * 4));
    private static final VoxelShape leg_r_w = Shapes.create(new AABB(0.0625 * 4, 0.0625 * 2D, 0.0625d * 2, 0.0625d * 8, 0.0625d * 6, 0.0625d * 4));

    private static final VoxelShape leg_l_e = Shapes.create(new AABB(0.0625 * 8, 0.0625 * 2D, 0.0625d * 12, 0.0625d * 12, 0.0625d * 6, 0.0625d * 14));
    private static final VoxelShape leg_l_w = Shapes.create(new AABB(0.0625 * 4, 0.0625 * 2D, 0.0625d * 12, 0.0625d * 8, 0.0625d * 6, 0.0625d * 14));

    public ChickenBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape directionalShape(Direction direction) {

        return switch (direction) {
            case NORTH -> Shapes.or(body_n_s, board, leg_r_n, leg_l_n);
            case SOUTH -> Shapes.or(body_n_s, board, leg_r_s, leg_l_s);
            case EAST -> Shapes.or(body_e_w, board, leg_r_e, leg_l_e);
            case WEST -> Shapes.or(body_e_w, board, leg_r_w, leg_l_w);
            default -> board;
        };
    }
}
