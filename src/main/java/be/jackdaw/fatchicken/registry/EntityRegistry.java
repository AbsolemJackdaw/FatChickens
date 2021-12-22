package be.jackdaw.fatchicken.registry;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.entity.FatChicken;
import be.jackdaw.fatchicken.entity.FatFish;
import be.jackdaw.fatchicken.entity.FatPig;
import be.jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FatChickenMod.MODID);

    public static final RegistryObject<EntityType<FatChicken>> FAT_CHICKEN = ENTITIES.register("fatchicken",
            () -> EntityType.Builder.of(FatChicken::new, MobCategory.CREATURE)
                    .sized(0.4F, 0.7F).clientTrackingRange(10).build(FatChickenMod.MODID + ":fatchicken"));

    public static final RegistryObject<EntityType<FatPig>> FAT_PIG = ENTITIES.register("fatpig",
            () -> EntityType.Builder.of(FatPig::new, MobCategory.CREATURE)
                    .sized(0.9F, 0.9F).clientTrackingRange(10).build(FatChickenMod.MODID + ":fatpig"));

    public static final RegistryObject<EntityType<FatFish>> FAT_FISH = ENTITIES.register("fatfish",
            () -> EntityType.Builder.of(FatFish::new, MobCategory.CREATURE)
                    .sized(0.5F, 0.5F).clientTrackingRange(10).build(FatChickenMod.MODID + ":fatfish"));

    //used for the hanging item registry
    public static final EntityType<TableCloth> TABLECLOTHTYPE = EntityType.Builder.<TableCloth>of(TableCloth::new, MobCategory.MISC)
            .sized(0.5F, 0.5F).clientTrackingRange(10).build(FatChickenMod.MODID + ":tablecloth");

    public static final RegistryObject<EntityType<TableCloth>> TABLECLOTH = ENTITIES.register("tablecloth",
            () -> TABLECLOTHTYPE);
}
