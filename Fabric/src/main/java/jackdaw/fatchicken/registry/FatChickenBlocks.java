package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;

public class FatChickenBlocks {

    public static void register() {
        Registry.register(Registry.BLOCK, CommonMod.reslocChicken, CommonMod.Blocks.CHICKEN_BLOCK);
        Registry.register(Registry.BLOCK, CommonMod.reslocPig, CommonMod.Blocks.PIG_BLOCK);
        Registry.register(Registry.BLOCK, CommonMod.reslocFish, CommonMod.Blocks.FISH_BLOCK);
        Registry.register(Registry.BLOCK, CommonMod.reslocLog, CommonMod.Blocks.ICE_CREAM_LOG);

    }
}
