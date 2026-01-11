package jackdaw.fatchicken.registry;

import jackdaw.fatchicken.CommonMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, CommonMod.ID);

    static {
        ITEMS.register(CommonMod.CHICKEN.concat(CommonMod.RAW), () -> CommonMod.Items.food(CommonMod.Keys.RAW_CHICKEN_ITEM));
        ITEMS.register(CommonMod.PIG.concat(CommonMod.RAW), () -> CommonMod.Items.food(CommonMod.Keys.RAW_FISH_ITEM));
        ITEMS.register(CommonMod.FISH.concat(CommonMod.RAW), () -> CommonMod.Items.food(CommonMod.Keys.RAW_PIG_ITEM));

        ITEMS.register(CommonMod.CHICKEN, () -> CommonMod.Items.CHICKEN);
        ITEMS.register(CommonMod.PIG, () -> CommonMod.Items.PIG);
        ITEMS.register(CommonMod.FISH, () -> CommonMod.Items.FISH);
        ITEMS.register(CommonMod.LOG, () -> CommonMod.Items.ICE_CREAM_LOG);

        ITEMS.register(CommonMod.CLOTH, () -> CommonMod.Items.TABLE_CLOTH);
    }
}
