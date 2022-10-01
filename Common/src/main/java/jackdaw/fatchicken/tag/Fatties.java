package jackdaw.fatchicken.tag;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class Fatties {

    public static final TagKey<EntityType<?>> TAG = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(CommonMod.MODID, "fatcap"));

    public static boolean hasFatCap(EntityType<?> tested) {
        return tested.is(TAG);
    }
}
