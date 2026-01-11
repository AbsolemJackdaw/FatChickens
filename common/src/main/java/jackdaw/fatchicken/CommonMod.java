package jackdaw.fatchicken;

import jackdaw.fatchicken.blocks.ChickenBlock;
import jackdaw.fatchicken.blocks.FishBlock;
import jackdaw.fatchicken.blocks.IceCreamLog;
import jackdaw.fatchicken.blocks.PigBlock;
import jackdaw.fatchicken.items.TableClothItem;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;

public class CommonMod {
    public static final String ID = "fatchicken";
    public static final String DATA = "fatties_data";

    public static final String CHICKEN = "fatchicken";
    public static final String PIG = "fatpig";
    public static final String FISH = "fatfish";
    public static final String LOG = "icecreamlog";
    public static final String CLOTH = "tablecloth";
    public static final String RAW = "_raw";

    public static class ResLocs {
        public static final Identifier log = Identifier.fromNamespaceAndPath(ID, LOG);
        public static final Identifier cloth = Identifier.fromNamespaceAndPath(ID, CLOTH);
        public static final Identifier chicken = Identifier.fromNamespaceAndPath(ID, CHICKEN);
        public static final Identifier pig = Identifier.fromNamespaceAndPath(ID, PIG);
        public static final Identifier fish = Identifier.fromNamespaceAndPath(ID, FISH);
        public static final Identifier chickenRaw = Identifier.fromNamespaceAndPath(ID, CHICKEN.concat(RAW));
        public static final Identifier pigRaw = Identifier.fromNamespaceAndPath(ID, PIG.concat(RAW));
        public static final Identifier fishRaw = Identifier.fromNamespaceAndPath(ID, FISH.concat(RAW));
        public static final Identifier data = Identifier.fromNamespaceAndPath(ID, DATA);
    }

    public static class Keys {
        public static final ResourceKey<EntityType<?>> CHICKEN_ENTITY = ResourceKey.create(Registries.ENTITY_TYPE, ResLocs.chicken);
        public static final ResourceKey<EntityType<?>> PIG_ENTITY = ResourceKey.create(Registries.ENTITY_TYPE, ResLocs.pig);
        public static final ResourceKey<EntityType<?>> FISH_ENTITY = ResourceKey.create(Registries.ENTITY_TYPE, ResLocs.fish);
        public static final ResourceKey<EntityType<?>> CLOTH_ENTITY = ResourceKey.create(Registries.ENTITY_TYPE, ResLocs.cloth);
        public static final ResourceKey<Block> CHICKEN_BLOCK = ResourceKey.create(Registries.BLOCK, ResLocs.chicken);
        public static final ResourceKey<Block> PIG_BLOCK = ResourceKey.create(Registries.BLOCK, ResLocs.pig);
        public static final ResourceKey<Block> FISH_BLOCK = ResourceKey.create(Registries.BLOCK, ResLocs.fish);
        public static final ResourceKey<Block> LOG_BLOCK = ResourceKey.create(Registries.BLOCK, ResLocs.log);
        public static final ResourceKey<Item> CHICKEN_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.chicken);
        public static final ResourceKey<Item> PIG_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.pig);
        public static final ResourceKey<Item> FISH_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.fish);
        public static final ResourceKey<Item> LOG_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.log);
        public static final ResourceKey<Item> CLOTH_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.cloth);
        public static final ResourceKey<Item> RAW_CHICKEN_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.chickenRaw);
        public static final ResourceKey<Item> RAW_PIG_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.pigRaw);
        public static final ResourceKey<Item> RAW_FISH_ITEM = ResourceKey.create(Registries.ITEM, ResLocs.fishRaw);
    }

    public static class Blocks {
        public static final ChickenBlock CHICKEN = new ChickenBlock(BlockBehaviour.Properties.of().noCollision().noOcclusion().destroyTime(1.0f).setId(Keys.CHICKEN_BLOCK));
        public static final PigBlock PIG = new PigBlock(BlockBehaviour.Properties.of().noCollision().noOcclusion().destroyTime(1.0f).setId(Keys.PIG_BLOCK));
        public static final FishBlock FISH = new FishBlock(BlockBehaviour.Properties.of().noCollision().noOcclusion().destroyTime(1.0f).setId(Keys.FISH_BLOCK));
        public static final IceCreamLog ICE_CREAM_LOG = new IceCreamLog(BlockBehaviour.Properties.of().noCollision().noOcclusion().destroyTime(1.0f).setId(Keys.LOG_BLOCK));
    }

    public static class Models {
        public static final Identifier TABLECLOTH = Identifier.fromNamespaceAndPath(CommonMod.ID, "block/" + CommonMod.CLOTH);
        public static final ModelLayerLocation CHICKEN = new ModelLayerLocation(Identifier.fromNamespaceAndPath(ID, CommonMod.CHICKEN), "");
        public static final ModelLayerLocation PIG = new ModelLayerLocation(Identifier.fromNamespaceAndPath(ID, CommonMod.PIG), "");
        public static final ModelLayerLocation FISH = new ModelLayerLocation(Identifier.fromNamespaceAndPath(ID, CommonMod.FISH), "");

    }

    public static class Food {
        public static final FoodProperties CHICKEN = new FoodProperties.Builder().nutrition(10).saturationModifier(1.0F).build();
        public static final FoodProperties PIG = new FoodProperties.Builder().nutrition(18).saturationModifier(1.6F).build();
        public static final FoodProperties FISH = new FoodProperties.Builder().nutrition(12).saturationModifier(1.2F).build();
        public static final FoodProperties ICE_CREAM_LOG = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4F).build();
        public static final Consumable REGEN = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(List.of(new MobEffectInstance(MobEffects.REGENERATION, 50, 1)))).build();

    }

    public static class Items {
        public static final ArrayList<Item> rawFood = new ArrayList<>();
        public static final ArrayList<Item> food = new ArrayList<>();

        public static Item food(ResourceKey<Item> id) {
            return new Item(new net.minecraft.world.item.Item.Properties().setId(id));
        }

        public static final TableClothItem TABLE_CLOTH = new TableClothItem(new net.minecraft.world.item.Item.Properties().setId(Keys.CLOTH_ITEM));
        public static final BlockItem ICE_CREAM_LOG = new BlockItem(Blocks.ICE_CREAM_LOG, foodProps(Food.ICE_CREAM_LOG).setId(Keys.LOG_ITEM));
        public static final BlockItem CHICKEN = new BlockItem(Blocks.CHICKEN, foodProps(Food.CHICKEN).setId(Keys.CHICKEN_ITEM));
        public static final BlockItem PIG = new BlockItem(Blocks.PIG, foodProps(Food.PIG).setId(Keys.PIG_ITEM));
        public static final BlockItem FISH = new BlockItem(Blocks.FISH, foodProps(Food.FISH).setId(Keys.FISH_ITEM));
    }

    public static class MobAttributes {
        public static final AttributeSupplier.Builder CHICKEN = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.10D);
        public static final AttributeSupplier.Builder PIG = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 14.0D).add(Attributes.MOVEMENT_SPEED, 0.10D);
        public static final AttributeSupplier.Builder FISH = Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
    }

    public static class RegisterFatties {
        public static void init() {
            FatAnimalRegistry.register(EntityType.PIG, () -> BuiltInRegistries.ENTITY_TYPE.getValue(ResLocs.pig));
            FatAnimalRegistry.register(EntityType.CHICKEN, () -> BuiltInRegistries.ENTITY_TYPE.getValue(ResLocs.chicken));
            FatAnimalRegistry.register(EntityType.SALMON, () -> BuiltInRegistries.ENTITY_TYPE.getValue(ResLocs.fish));
        }
    }

    private static net.minecraft.world.item.Item.Properties foodProps(FoodProperties props) {
        return new net.minecraft.world.item.Item.Properties().food(props, Food.REGEN);
    }
}
