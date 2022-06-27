package jackdaw.fatchicken.entity;

import jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.Level;

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
