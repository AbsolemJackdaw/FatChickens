package jackdaw.fatchicken.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.level.Level;

public class FatFish extends Salmon {
    public FatFish(EntityType<? extends Salmon> type, Level level) {
        super(type, level);
    }
}
