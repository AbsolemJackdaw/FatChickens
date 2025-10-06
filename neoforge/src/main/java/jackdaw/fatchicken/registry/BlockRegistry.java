package jackdaw.fatchicken.registry;


import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.blocks.ChickenBlock;
import jackdaw.fatchicken.blocks.FishBlock;
import jackdaw.fatchicken.blocks.IceCreamLog;
import jackdaw.fatchicken.blocks.PigBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, CommonMod.MODID);
    public static DeferredHolder<Block, ChickenBlock> FATCHICKEN = BLOCKS.register(CommonMod.CHICKEN_ID, () -> jackdaw.fatchicken.CommonMod.Blocks.CHICKEN_BLOCK);
    public static DeferredHolder<Block, PigBlock> FATPIG = BLOCKS.register(CommonMod.PIG_ID, () -> jackdaw.fatchicken.CommonMod.Blocks.PIG_BLOCK);
    public static DeferredHolder<Block, FishBlock> FATFISH = BLOCKS.register(CommonMod.FISH_ID, () -> jackdaw.fatchicken.CommonMod.Blocks.FISH_BLOCK);
    public static DeferredHolder<Block, IceCreamLog> CAKE = BLOCKS.register(CommonMod.LOG_ID, () -> jackdaw.fatchicken.CommonMod.Blocks.ICE_CREAM_LOG);

}
