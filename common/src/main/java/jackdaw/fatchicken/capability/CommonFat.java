package jackdaw.fatchicken.capability;

import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

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

    public void writeFatData(ValueOutput tag) {
        tag.putInt("chance", fatChance);
    }

    public void readFatData(ValueInput tag) {
        this.fatChance = tag.getIntOr("chance", 0);
    }
}
