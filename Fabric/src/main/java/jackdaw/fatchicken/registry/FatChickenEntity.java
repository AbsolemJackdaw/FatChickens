package jackdaw.fatchicken.registry;


import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import jackdaw.fatchicken.entity.TableCloth;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.MobCategory;

public class FatChickenEntity {

    public static void register() {
        Registry.register(Registry.ENTITY_TYPE, CommonMod.Entity.FAT_CHICKEN,
                FabricEntityTypeBuilder.<FatChicken>create(MobCategory.CREATURE, FatChicken::new).dimensions(EntityDimensions.scalable(0.4F, 0.7F)).trackRangeBlocks(10).build());
        Registry.register(Registry.ENTITY_TYPE, CommonMod.Entity.FAT_PIG,
                FabricEntityTypeBuilder.<FatPig>create(MobCategory.CREATURE, FatPig::new).dimensions(EntityDimensions.scalable(0.9F, 0.9F)).trackRangeBlocks(10).build());
        Registry.register(Registry.ENTITY_TYPE, CommonMod.Entity.FAT_FISH,
                FabricEntityTypeBuilder.<FatFish>create(MobCategory.CREATURE, FatFish::new).dimensions(EntityDimensions.scalable(0.5f, 0.5f)).trackRangeBlocks(10).build());
        Registry.register(Registry.ENTITY_TYPE, CommonMod.Entity.TABLE_CLOTH_ENTITY,
                FabricEntityTypeBuilder.<TableCloth>create(MobCategory.MISC, TableCloth::new).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(10).build());
    }
}
