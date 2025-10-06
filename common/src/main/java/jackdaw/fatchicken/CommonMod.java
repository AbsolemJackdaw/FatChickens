package jackdaw.fatchicken;

import jackdaw.fatchicken.blocks.ChickenBlock;
import jackdaw.fatchicken.blocks.FishBlock;
import jackdaw.fatchicken.blocks.IceCreamLog;
import jackdaw.fatchicken.blocks.PigBlock;
import jackdaw.fatchicken.items.TableClothItem;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.function.Supplier;

public class CommonMod {
    public static final String MODID = "fatchicken";
    public static final String DATA_ID = "fatties_data";

    public static final String CHICKEN_ID = "fatchicken";
    public static final String PIG_ID = "fatpig";
    public static final String FISH_ID = "fatfish";
    public static final String LOG_ID = "icecreamlog";
    public static final String CLOTH_ID = "tablecloth";
    public static final String RAW_ID = "_raw";

    public static final ResourceLocation reslocLog = ResourceLocation.fromNamespaceAndPath(MODID, LOG_ID);
    public static final ResourceLocation reslocCloth = ResourceLocation.fromNamespaceAndPath(MODID, CLOTH_ID);
    public static final ResourceLocation reslocChicken = ResourceLocation.fromNamespaceAndPath(MODID, CHICKEN_ID);
    public static final ResourceLocation reslocPig = ResourceLocation.fromNamespaceAndPath(MODID, PIG_ID);
    public static final ResourceLocation reslocFish = ResourceLocation.fromNamespaceAndPath(MODID, FISH_ID);

    public static class Blocks {
        public static final ChickenBlock CHICKEN_BLOCK = new ChickenBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().destroyTime(1.0f));
        public static final PigBlock PIG_BLOCK = new PigBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().destroyTime(1.0f));
        public static final FishBlock FISH_BLOCK = new FishBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().destroyTime(1.0f));
        public static final IceCreamLog ICE_CREAM_LOG = new IceCreamLog(BlockBehaviour.Properties.of().noCollission().noOcclusion().destroyTime(1.0f));
    }

    public static class Models {
        public static final ResourceLocation TABLECLOTH_RESLOC = ResourceLocation.fromNamespaceAndPath(CommonMod.MODID, "block/" + CommonMod.CLOTH_ID);
        public static final ModelResourceLocation TABLECLOTH_MODEL = new ModelResourceLocation(TABLECLOTH_RESLOC, "standalone");
        public static final ModelLayerLocation FATCHICKEN = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, CHICKEN_ID), "");
        public static final ModelLayerLocation FATPIG = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, PIG_ID), "");
        public static final ModelLayerLocation FATFISH = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, FISH_ID), "");

        public static Supplier<BakedModel> LOADER_SPECIFIC_MODEL;
    }

    public static class Food {
        public static final FoodProperties chicken = new FoodProperties.Builder().nutrition(10).saturationModifier(1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties pig = new FoodProperties.Builder().nutrition(18).saturationModifier(1.6F).effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties fish = new FoodProperties.Builder().nutrition(12).saturationModifier(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties cake = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4F).build();
    }

    public static class Items {
        public static final ArrayList<Item> rawFood = new ArrayList<>();
        public static final ArrayList<Item> food = new ArrayList<>();

        public static Item food() {
            return new Item(new net.minecraft.world.item.Item.Properties());
        }

        public static final TableClothItem TABLE_CLOTH_ITEM = new TableClothItem(new net.minecraft.world.item.Item.Properties());
        public static final BlockItem ICE_CREAM_LOG_ITEM = new BlockItem(Blocks.ICE_CREAM_LOG, foodProps(Food.cake));
        public static final BlockItem CHICKEN_BLOCK_ITEM = new BlockItem(Blocks.CHICKEN_BLOCK, foodProps(Food.chicken));
        public static final BlockItem PIG_BLOCK_ITEM = new BlockItem(Blocks.PIG_BLOCK, foodProps(Food.pig));
        public static final BlockItem FISH_BLOCK_ITEM = new BlockItem(Blocks.FISH_BLOCK, foodProps(Food.fish));
    }

    public static class MobAttributes {
        public static final AttributeSupplier.Builder CHICKEN = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.10D);
        public static final AttributeSupplier.Builder PIG = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.MOVEMENT_SPEED, 0.10D);
        public static final AttributeSupplier.Builder FISH = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
    }

    public static class RegisterFatties {
        public static void init() {
            FatAnimalRegistry.register(EntityType.PIG, () -> BuiltInRegistries.ENTITY_TYPE.get(reslocPig));
            FatAnimalRegistry.register(EntityType.CHICKEN, () -> BuiltInRegistries.ENTITY_TYPE.get(reslocChicken));
            FatAnimalRegistry.register(EntityType.SALMON, () -> BuiltInRegistries.ENTITY_TYPE.get(reslocFish));
        }
    }

    private static net.minecraft.world.item.Item.Properties foodProps(FoodProperties props) {
        return new net.minecraft.world.item.Item.Properties().food(props);
    }
}
