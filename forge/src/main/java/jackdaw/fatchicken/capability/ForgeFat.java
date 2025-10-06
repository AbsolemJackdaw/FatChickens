package jackdaw.fatchicken.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.LazyOptional;

public class ForgeFat extends CommonFat {

    public static LazyOptional<CommonFat> get(LivingEntity animal) {
        return animal.getCapability(FatCap.CAPABILITY, null);
    }
}
