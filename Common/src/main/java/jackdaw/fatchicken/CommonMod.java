package jackdaw.fatchicken;

import jackdaw.fatchicken.blocks.ChickenBlock;
import jackdaw.fatchicken.blocks.FishBlock;
import jackdaw.fatchicken.blocks.IceCreamLog;
import jackdaw.fatchicken.blocks.PigBlock;
import jackdaw.fatchicken.items.TableClothItem;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class CommonMod {
    public static final String MODID = "fatchicken";

    public static final String CHICKEN_ID = "fatchicken";
    public static final String PIG_ID = "fatpig";
    public static final String FISH_ID = "fatfish";
    public static final String LOG_ID = "icecreamlog";
    public static final String CLOTH_ID = "tablecloth";
    public static final String RAW_ID = "_raw";

    public static final ResourceLocation reslocLog = new ResourceLocation(MODID, LOG_ID);
    public static final ResourceLocation reslocCloth = new ResourceLocation(MODID, CLOTH_ID);
    public static final ResourceLocation reslocChicken = new ResourceLocation(MODID, CHICKEN_ID);
    public static final ResourceLocation reslocPig = new ResourceLocation(MODID, PIG_ID);
    public static final ResourceLocation reslocFish = new ResourceLocation(MODID, FISH_ID);

    public static class Entity {
        public static final ResourceLocation TABLE_CLOTH_ENTITY = new ResourceLocation(MODID, CLOTH_ID);
        public static final ResourceLocation FAT_PIG = new ResourceLocation(MODID, PIG_ID);
        public static final ResourceLocation FAT_FISH = new ResourceLocation(MODID, FISH_ID);
        public static final ResourceLocation FAT_CHICKEN = new ResourceLocation(MODID, CHICKEN_ID);
    }

    public static class Blocks {
        public static final ChickenBlock CHICKEN_BLOCK = new ChickenBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().noOcclusion().destroyTime(1.0f));
        public static final PigBlock PIG_BLOCK = new PigBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().noOcclusion().destroyTime(1.0f));
        public static final FishBlock FISH_BLOCK = new FishBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().noOcclusion().destroyTime(1.0f));
        public static final IceCreamLog ICE_CREAM_LOG = new IceCreamLog(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().noOcclusion().destroyTime(1.0f));
    }

    public static class Models {
        public static final ModelResourceLocation TABLECLOTH = new ModelResourceLocation(new ResourceLocation(MODID, CLOTH_ID), "");
        public static final ModelLayerLocation FATCHICKEN = new ModelLayerLocation(new ResourceLocation(MODID), CHICKEN_ID);
        public static final ModelLayerLocation FATPIG = new ModelLayerLocation(new ResourceLocation(MODID), PIG_ID);
        public static final ModelLayerLocation FATFISH = new ModelLayerLocation(new ResourceLocation(MODID), FISH_ID);

    }

    public static class Food {
        public static final FoodProperties chicken = new FoodProperties.Builder().nutrition(10).saturationMod(1.0F).meat().effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties pig = new FoodProperties.Builder().nutrition(18).saturationMod(1.6F).meat().effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties fish = new FoodProperties.Builder().nutrition(12).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 1f).build();
        public static final FoodProperties cake = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).meat().build();
    }

    public static class Items {

        public static Item food() {
            return new Item(new net.minecraft.world.item.Item.Properties().tab(CreativeModeTab.TAB_FOOD));
        }

        public static final TableClothItem TABLE_CLOTH_ITEM = new TableClothItem(new net.minecraft.world.item.Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
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
            FatAnimalRegistry.register(EntityType.PIG, () -> Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_PIG));
            FatAnimalRegistry.register(EntityType.CHICKEN, () -> Registry.ENTITY_TYPE.get(Entity.FAT_CHICKEN));
            FatAnimalRegistry.register(EntityType.SALMON, () -> Registry.ENTITY_TYPE.get(Entity.FAT_FISH)); ;
        }
    }

    private static net.minecraft.world.item.Item.Properties foodProps(FoodProperties props) {
        return new net.minecraft.world.item.Item.Properties().food(props).tab(CreativeModeTab.TAB_FOOD);
    }
}
