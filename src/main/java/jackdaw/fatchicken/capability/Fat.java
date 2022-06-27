package jackdaw.fatchicken.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.LazyOptional;

import java.util.Random;

public class Fat {

    //fat chacne in percent.
    private int fatChance = 0;
    private Random rand = new Random();
    private boolean growfat = false;

    public static LazyOptional<Fat> get(LivingEntity animal) {

        return animal.getCapability(FatCap.CAPABILITY, null);
    }

    public Tag writeData() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("chance", fatChance);
        return tag;
    }

    public void readData(Tag nbt) {

        CompoundTag tag = ((CompoundTag) nbt);
        this.fatChance = tag.getInt("chance");
    }

    public void feed() {
        fatChance += rand.nextInt(5);
        growfat = rand.nextInt(99) + 1 < fatChance;
    }

    public boolean isFat() {
        return growfat;
    }
}
