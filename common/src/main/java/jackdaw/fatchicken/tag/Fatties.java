package jackdaw.fatchicken.tag;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class Fatties {

    public static final TagKey<EntityType<?>> TAG = TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(CommonMod.ID, "fatcap"));

    public static boolean hasFatCap(EntityType<?> tested) {
        return tested.is(TAG);
    }
}
