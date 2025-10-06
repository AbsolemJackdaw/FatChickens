package jackdaw.fatchicken.registry;


import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import jackdaw.fatchicken.entity.TableCloth;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class FatChickenEntities {
    public static final EntityType<FatChicken> FAT_CHICKEN_ENTITY_TYPE = Registry.register(BuiltInRegistries.ENTITY_TYPE, CommonMod.reslocChicken, EntityType.Builder.of(FatChicken::new, MobCategory.MISC)
            .updateInterval(1)
            .clientTrackingRange(256)
            .sized(0.4f, 0.7f)
            .build(CommonMod.CHICKEN_ID)
    );
    public static final EntityType<FatPig> FAT_PIG_ENTITY_TYPE = Registry.register(BuiltInRegistries.ENTITY_TYPE, CommonMod.reslocPig, EntityType.Builder.of(FatPig::new, MobCategory.MISC)
            .updateInterval(1)
            .clientTrackingRange(256)
            .sized(0.9f, 0.9f)
            .build(CommonMod.PIG_ID)
    );
    public static final EntityType<FatFish> FAT_FISH_ENTITY_TYPE = Registry.register(BuiltInRegistries.ENTITY_TYPE, CommonMod.reslocFish, EntityType.Builder.of(FatFish::new, MobCategory.MISC)
            .updateInterval(1)
            .clientTrackingRange(256)
            .sized(0.5f, 0.5f)
            .build(CommonMod.FISH_ID)
    );
    public static final EntityType<TableCloth> CLOTHTYPE = Registry.register(BuiltInRegistries.ENTITY_TYPE, CommonMod.reslocCloth, EntityType.Builder.of(TableCloth::create, MobCategory.MISC)
            .updateInterval(1)
            .clientTrackingRange(256)
            .sized(0.5f, 0.5f)
            .build(CommonMod.CLOTH_ID)
    );

    public static void register() {
    }
}
