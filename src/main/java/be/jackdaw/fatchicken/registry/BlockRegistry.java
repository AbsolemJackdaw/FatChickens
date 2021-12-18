package be.jackdaw.fatchicken.registry;

import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.blocks.ChickenBlock;
import be.jackdaw.fatchicken.blocks.PigBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FatChickenMod.MODID);
    public static RegistryObject<Block> FATCHICKEN = BLOCKS.register("fatchicken", () -> new ChickenBlock(BlockBehaviour.Properties.of(Material.CAKE).noOcclusion().destroyTime(1.0f)));
    public static RegistryObject<Block> FATPIG = BLOCKS.register("fatpig", () -> new PigBlock(BlockBehaviour.Properties.of(Material.CAKE).noOcclusion().destroyTime(1.0f)));

}
