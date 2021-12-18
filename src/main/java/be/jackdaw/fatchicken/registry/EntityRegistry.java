package be.jackdaw.fatchicken.registry;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.entity.FatChicken;
import be.jackdaw.fatchicken.entity.FatPig;
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
}
