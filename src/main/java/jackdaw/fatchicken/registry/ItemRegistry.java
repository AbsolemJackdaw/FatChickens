package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.items.TableClothItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FatChickenMod.MODID);
    private static final FoodProperties chicken = new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).meat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
    private static final FoodProperties pig = new FoodProperties.Builder().nutrition(18).saturationMod(1.6F).meat().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
    private static final FoodProperties fish = new FoodProperties.Builder().nutrition(12).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();

    private static final FoodProperties cake = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).meat().build();

    public static RegistryObject<Item> COOKED_FATCHICKEN = ITEMS.register("fatchicken", () -> new BlockItem(BlockRegistry.FATCHICKEN.get(), new Item.Properties().
            food(chicken).tab(CreativeModeTab.TAB_FOOD)));
    public static RegistryObject<Item> FATCHICKEN = ITEMS.register("fatchicken_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static RegistryObject<Item> COOKED_FATPIG = ITEMS.register("fatpig", () -> new BlockItem(BlockRegistry.FATPIG.get(), new Item.Properties().
            food(pig).tab(CreativeModeTab.TAB_FOOD)));
    public static RegistryObject<Item> FATPIG = ITEMS.register("fatpig_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static RegistryObject<Item> COOKED_FATFISH = ITEMS.register("fatfish", () -> new BlockItem(BlockRegistry.FATFISH.get(), new Item.Properties().
            food(fish).tab(CreativeModeTab.TAB_FOOD)));
    public static RegistryObject<Item> FATFISH = ITEMS.register("fatfish_raw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static RegistryObject<Item> CAKE = ITEMS.register("icecreamlog", () -> new BlockItem(BlockRegistry.CAKE.get(), new Item.Properties().
            food(cake).tab(CreativeModeTab.TAB_FOOD)));

    public static RegistryObject<Item> TABLECLOTH = ITEMS.register("tablecloth", () -> new TableClothItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

}
