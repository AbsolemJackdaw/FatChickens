package jackdaw.fatchicken.capability;

import jackdaw.fatchicken.FatChickenMod;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class FatCap implements ICapabilitySerializable<CompoundTag> {

    /**
     * Unique key to identify the attached provider from others
     */
    public static final ResourceLocation KEY = new ResourceLocation(FatChickenMod.MODID, "fat_cap");
    /*
     * This field will contain the forge-allocated Capability class. This instance
     * will be initialized internally by Forge, upon calling register in FMLCommonSetupEvent.
     */
    public static Capability<Fat> CAPABILITY = CapabilityManager.get(new CapabilityToken<Fat>() {
    });
    final Fat data = new Fat();

    @Override
    public CompoundTag serializeNBT() {

        return (CompoundTag) data.writeData();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

        data.readData(nbt);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {

        if (cap == FatCap.CAPABILITY)
            return (LazyOptional<T>) LazyOptional.of(this::getImpl);

        return LazyOptional.empty();
    }

    private Fat getImpl() {

        return data;
    }
}
