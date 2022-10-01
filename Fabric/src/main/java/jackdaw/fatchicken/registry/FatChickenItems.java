package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class FatChickenItems {

    public static void register() {
        Registry.register(Registry.ITEM, CommonMod.reslocCloth, CommonMod.Items.TABLE_CLOTH_ITEM);
        Registry.register(Registry.ITEM, CommonMod.reslocLog, CommonMod.Items.ICE_CREAM_LOG_ITEM);

        Registry.register(Registry.ITEM, CommonMod.reslocChicken, CommonMod.Items.CHICKEN_BLOCK_ITEM);
        Registry.register(Registry.ITEM, CommonMod.reslocPig, CommonMod.Items.PIG_BLOCK_ITEM);
        Registry.register(Registry.ITEM, CommonMod.reslocFish, CommonMod.Items.FISH_BLOCK_ITEM);

        Registry.register(Registry.ITEM, new ResourceLocation(CommonMod.MODID, CommonMod.CHICKEN_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food());
        Registry.register(Registry.ITEM, new ResourceLocation(CommonMod.MODID, CommonMod.PIG_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food());
        Registry.register(Registry.ITEM, new ResourceLocation(CommonMod.MODID, CommonMod.FISH_ID.concat(CommonMod.RAW_ID)), CommonMod.Items.food());
    }
}
