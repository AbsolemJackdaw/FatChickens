package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FatChickenItems {

    public static void register() {
        Registry.register(BuiltInRegistries.ITEM, CommonMod.reslocCloth, CommonMod.Items.TABLE_CLOTH_ITEM);

        var food = Arrays.stream(new Item[]{
                Registry.register(BuiltInRegistries.ITEM, CommonMod.reslocLog, CommonMod.Items.ICE_CREAM_LOG_ITEM),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.reslocChicken, CommonMod.Items.CHICKEN_BLOCK_ITEM),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.reslocPig, CommonMod.Items.PIG_BLOCK_ITEM),
                Registry.register(BuiltInRegistries.ITEM, CommonMod.reslocFish, CommonMod.Items.FISH_BLOCK_ITEM)
        }).toList();

        var rawFood = Arrays.stream(new Item[]{
                Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(CommonMod.MODID, CommonMod.CHICKEN_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food()),
                Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(CommonMod.MODID, CommonMod.PIG_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food()),
                Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(CommonMod.MODID, CommonMod.FISH_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food())
        }).toList();
        CommonMod.Items.rawFood.addAll(rawFood);
        CommonMod.Items.food.addAll(food);

    }
}
