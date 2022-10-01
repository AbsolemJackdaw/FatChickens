package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CommonMod.MODID);
    public static RegistryObject<Block> FATCHICKEN = BLOCKS.register(CommonMod.CHICKEN_ID, () -> CommonMod.Blocks.CHICKEN_BLOCK);
    public static RegistryObject<Block> FATPIG = BLOCKS.register(CommonMod.PIG_ID, () -> CommonMod.Blocks.PIG_BLOCK);
    public static RegistryObject<Block> FATFISH = BLOCKS.register(CommonMod.FISH_ID, () -> CommonMod.Blocks.FISH_BLOCK);
    public static RegistryObject<Block> CAKE = BLOCKS.register(CommonMod.LOG_ID, () -> CommonMod.Blocks.ICE_CREAM_LOG);

}
