package jackdaw.fatchicken;

import jackdaw.fatchicken.events.FeedAnimalsEvent;
import jackdaw.fatchicken.registry.FatChickenAttributes;
import jackdaw.fatchicken.registry.FatChickenBlocks;
import jackdaw.fatchicken.registry.FatChickenEntity;
import jackdaw.fatchicken.registry.FatChickenItems;
import net.fabricmc.api.ModInitializer;

public class FatChicken implements ModInitializer {
    @Override
    public void onInitialize() {
        FatChickenBlocks.register();
        FatChickenEntity.register();
        FatChickenItems.register();
        FatChickenAttributes.register();

        FeedAnimalsEvent.register();

        CommonMod.RegisterFatties.init();
    }
}
