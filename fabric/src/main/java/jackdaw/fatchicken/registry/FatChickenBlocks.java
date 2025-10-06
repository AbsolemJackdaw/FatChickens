package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class FatChickenBlocks {

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.reslocChicken, CommonMod.Blocks.CHICKEN_BLOCK);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.reslocPig, CommonMod.Blocks.PIG_BLOCK);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.reslocFish, CommonMod.Blocks.FISH_BLOCK);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.reslocLog, CommonMod.Blocks.ICE_CREAM_LOG);
    }
}
