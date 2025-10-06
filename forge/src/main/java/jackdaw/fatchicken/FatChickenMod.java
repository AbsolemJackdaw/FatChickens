package jackdaw.fatchicken;

import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.FatChickenEntities;
import jackdaw.fatchicken.registry.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

@Mod(value = CommonMod.MODID)
public class FatChickenMod {

    public FatChickenMod(IEventBus bus) {
        ItemRegistry.ITEMS.register(bus);
        BlockRegistry.BLOCKS.register(bus);
        CommonMod.RegisterFatties.init();
    }
}
