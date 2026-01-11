package jackdaw.fatchicken;

import jackdaw.fatchicken.events.FeedAnimalsEvent;
import jackdaw.fatchicken.registry.FatChickenAttributes;
import jackdaw.fatchicken.registry.FatChickenBlocks;
import jackdaw.fatchicken.registry.FatChickenEntities;
import jackdaw.fatchicken.registry.FatChickenItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class FatChicken implements ModInitializer {
    @Override
    public void onInitialize() {
        FatChickenBlocks.register();
        FatChickenEntities.register();
        FatChickenItems.register();
        FatChickenAttributes.register();
        FeedAnimalsEvent.register();
        CommonMod.RegisterFatties.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(content -> {
            CommonMod.Items.food.forEach(content::accept);
            CommonMod.Items.rawFood.forEach(content::accept);
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.accept(CommonMod.Items.TABLE_CLOTH);
        });
    }
}
