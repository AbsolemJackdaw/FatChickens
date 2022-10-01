package jackdaw.fatchicken.capability;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.tag.Fatties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class Components implements EntityComponentInitializer {

    // retrieving a type for my component or for a required dependency's
    public static final ComponentKey<FabricFat> DATA = ComponentRegistry.getOrCreate(new ResourceLocation(CommonMod.MODID, "fatcap"), FabricFat.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(Entity.class, DATA, (entity -> entity.getType().is(Fatties.TAG) ? new FabricFat() : new FabricFat.Fake()));


    }
}