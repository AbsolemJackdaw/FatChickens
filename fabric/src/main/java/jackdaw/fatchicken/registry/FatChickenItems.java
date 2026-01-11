package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Arrays;

public class FatChickenItems {

    public static void register() {
        Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.cloth, CommonMod.Items.TABLE_CLOTH);

        var food = Arrays.stream(new Item[]{
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.log, CommonMod.Items.ICE_CREAM_LOG),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.chicken, CommonMod.Items.CHICKEN),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.pig, CommonMod.Items.PIG),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.fish, CommonMod.Items.FISH)
        }).toList();

        var rawFood = Arrays.stream(new Item[]{
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.chickenRaw, CommonMod.Items.food(CommonMod.Keys.RAW_CHICKEN_ITEM)),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.fishRaw, CommonMod.Items.food(CommonMod.Keys.RAW_FISH_ITEM)),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.ResLocs.pigRaw, CommonMod.Items.food(CommonMod.Keys.RAW_PIG_ITEM))
        }).toList();
        CommonMod.Items.rawFood.addAll(rawFood);
        CommonMod.Items.food.addAll(food);

    }
}
