package jackdaw.fatchicken.capability;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public class Components implements EntityComponentInitializer {

    public static final ComponentKey<FabricFat> DATA = ComponentRegistry.getOrCreate(ResourceLocation.fromNamespaceAndPath(CommonMod.MODID, CommonMod.DATA_ID), FabricFat.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(LivingEntity.class, DATA, entity -> new FabricFat());
    }

}