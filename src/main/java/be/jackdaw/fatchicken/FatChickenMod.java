package be.jackdaw.fatchicken;

import be.jackdaw.fatchicken.registry.BlockRegistry;
import be.jackdaw.fatchicken.registry.EntityRegistry;
import be.jackdaw.fatchicken.registry.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = FatChickenMod.MODID)
public class FatChickenMod {
    public static final String MODID = "fatchicken";

    public FatChickenMod() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityRegistry.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
