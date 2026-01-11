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
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, CommonMod.ID);
    public static DeferredHolder<Block, ChickenBlock> FATCHICKEN = BLOCKS.register(CommonMod.CHICKEN, () -> jackdaw.fatchicken.CommonMod.Blocks.CHICKEN);
    public static DeferredHolder<Block, PigBlock> FATPIG = BLOCKS.register(CommonMod.PIG, () -> jackdaw.fatchicken.CommonMod.Blocks.PIG);
    public static DeferredHolder<Block, FishBlock> FATFISH = BLOCKS.register(CommonMod.FISH, () -> jackdaw.fatchicken.CommonMod.Blocks.FISH);
    public static DeferredHolder<Block, IceCreamLog> CAKE = BLOCKS.register(CommonMod.LOG, () -> jackdaw.fatchicken.CommonMod.Blocks.ICE_CREAM_LOG);

}
