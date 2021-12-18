package be.jackdaw.fatchicken.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PigBlock extends FoodBlock {
    private static final VoxelShape porc = Shapes.create(new AABB(0.0625 * 2d, 0.0D, 0.0625d * 2d, 0.0625d * 14d, 0.0625d * 4d, 0.0625d * 14d));

    public PigBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape directionalShape(Direction direction) {
        return porc;
    }
}
