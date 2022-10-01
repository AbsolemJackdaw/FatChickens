package jackdaw.fatchicken;

import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.EntityRegistry;
import jackdaw.fatchicken.registry.ItemRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = CommonMod.MODID)
public class FatChickenMod {

    public FatChickenMod() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntityRegistry.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        CommonMod.RegisterFatties.init();
    }
}
