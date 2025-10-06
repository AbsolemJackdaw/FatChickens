package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class FatChickenAttributes {
    public static void register() {
        FabricDefaultAttributeRegistry.register(FatChickenEntities.FAT_PIG_ENTITY_TYPE, CommonMod.MobAttributes.PIG);
        FabricDefaultAttributeRegistry.register(FatChickenEntities.FAT_FISH_ENTITY_TYPE, CommonMod.MobAttributes.FISH);
        FabricDefaultAttributeRegistry.register(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, CommonMod.MobAttributes.CHICKEN);
    }
}
