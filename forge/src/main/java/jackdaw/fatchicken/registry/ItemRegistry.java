package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CommonMod.MODID);

    static {
        ITEMS.register(CommonMod.CHICKEN_ID.concat(CommonMod.RAW_ID), CommonMod.Items::food);
        ITEMS.register(CommonMod.PIG_ID.concat(CommonMod.RAW_ID), CommonMod.Items::food);
        ITEMS.register(CommonMod.FISH_ID.concat(CommonMod.RAW_ID), CommonMod.Items::food);

        ITEMS.register(CommonMod.CHICKEN_ID, () -> CommonMod.Items.CHICKEN_BLOCK_ITEM);
        ITEMS.register(CommonMod.PIG_ID, () -> CommonMod.Items.PIG_BLOCK_ITEM);
        ITEMS.register(CommonMod.FISH_ID, () -> CommonMod.Items.FISH_BLOCK_ITEM);

        ITEMS.register(CommonMod.LOG_ID, () -> CommonMod.Items.ICE_CREAM_LOG_ITEM);
        ITEMS.register(CommonMod.CLOTH_ID, () -> CommonMod.Items.TABLE_CLOTH_ITEM);
    }
}
