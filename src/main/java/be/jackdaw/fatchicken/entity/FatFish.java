package be.jackdaw.fatchicken.entity;

import be.jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.level.Level;

public class FatFish extends Salmon {
    public FatFish(EntityType<? extends Salmon> type, Level level) {
        super(type, level);
    }

    public static FatFish make(Level level) {
        return new FatFish(EntityRegistry.FAT_FISH.get(), level);
    }

}
