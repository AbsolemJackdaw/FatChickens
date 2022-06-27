package be.jackdaw.fatchicken.entity;

import be.jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FatPig extends Pig {
    public FatPig(EntityType<? extends Pig> type, Level level) {
        super(type, level);
    }

    public static FatPig make(Level level) {
        return new FatPig(EntityRegistry.FAT_PIG.get(), level);
    }

    @Override
    public boolean canBreed() {
        return false;
    }
}
