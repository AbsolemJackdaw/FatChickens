package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class FatChickenBlocks {

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.ResLocs.chicken, CommonMod.Blocks.CHICKEN);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.ResLocs.pig, CommonMod.Blocks.PIG);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.ResLocs.fish, CommonMod.Blocks.FISH);
        Registry.register(BuiltInRegistries.BLOCK, CommonMod.ResLocs.log, CommonMod.Blocks.ICE_CREAM_LOG);
    }
}
