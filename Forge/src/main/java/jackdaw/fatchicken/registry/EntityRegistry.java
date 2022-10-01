package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CommonMod.MODID);

    public static final RegistryObject<EntityType<FatChicken>> FAT_CHICKEN = ENTITIES.register(
            CommonMod.Entity.FAT_CHICKEN.getPath(),
            () -> EntityType.Builder.of(
                    FatChicken::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.7F)
                    .clientTrackingRange(10)
                    .build(CommonMod.Entity.FAT_CHICKEN.getPath()));

    public static final RegistryObject<EntityType<FatPig>> FAT_PIG = ENTITIES.register(CommonMod.Entity.FAT_PIG.getPath(),
            () -> EntityType.Builder.of(FatPig::new, MobCategory.CREATURE)
                    .sized(0.9F, 0.9F).clientTrackingRange(10).build(CommonMod.Entity.FAT_PIG.getPath()));

    public static final RegistryObject<EntityType<FatFish>> FAT_FISH = ENTITIES.register(CommonMod.Entity.FAT_FISH.getPath(),
            () -> EntityType.Builder.of(FatFish::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.5F).clientTrackingRange(10).build(CommonMod.Entity.FAT_PIG.getPath()));

    //used for the hanging item registry
    public static final RegistryObject<EntityType<TableCloth>> TABLECLOTH = ENTITIES.register(CommonMod.Entity.TABLE_CLOTH_ENTITY.getPath(),
            () -> EntityType.Builder.<TableCloth>of(TableCloth::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(10).build(CommonMod.Entity.TABLE_CLOTH_ENTITY.getPath()));
}
