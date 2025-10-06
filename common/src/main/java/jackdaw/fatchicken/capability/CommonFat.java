package jackdaw.fatchicken.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

import java.util.Random;

public class CommonFat {

    //fat chance in percent.
    int fatChance = 0;
    Random rand = new Random();
    boolean growfat = false;


    public void feed() {
        fatChance += rand.nextInt(5);
        growfat = rand.nextInt(99) + 1 < fatChance;
    }

    public boolean isFat() {
        return growfat;
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

}
