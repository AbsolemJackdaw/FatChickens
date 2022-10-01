package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

public class FatChickenAttributes {

    public static void register() {
        FabricDefaultAttributeRegistry.register((EntityType<FatChicken>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_CHICKEN), CommonMod.MobAttributes.CHICKEN);
        FabricDefaultAttributeRegistry.register((EntityType<FatPig>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_PIG), CommonMod.MobAttributes.PIG);
        FabricDefaultAttributeRegistry.register((EntityType<FatFish>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_FISH), CommonMod.MobAttributes.FISH);

    }
}
