package jackdaw.fatchicken;

import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.EntityRegistry;
import jackdaw.fatchicken.registry.FatAnimalRegistry;
import jackdaw.fatchicken.registry.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = FatChickenMod.MODID)
public class FatChickenMod {
    public static final String MODID = "fatchicken";

    public FatChickenMod() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityRegistry.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        FatAnimalRegistry.register(EntityType.PIG, EntityRegistry.FAT_PIG::get);
        FatAnimalRegistry.register(EntityType.CHICKEN, EntityRegistry.FAT_CHICKEN::get);
        FatAnimalRegistry.register(EntityType.SALMON, EntityRegistry.FAT_FISH::get); ;
    }
}
