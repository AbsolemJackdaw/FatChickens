package jackdaw.fatchicken;

import jackdaw.fatchicken.capability.CommonFat;
import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@Mod(value = CommonMod.MODID)
public class FatChickenMod {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, CommonMod.MODID);
    public static final Supplier<AttachmentType<CommonFat>> FATTIESDATA = ATTACHMENT_TYPES.register(
            CommonMod.DATA_ID, () -> AttachmentType.builder(CommonFat::new).build()
    );

    public FatChickenMod(IEventBus bus) {
        ItemRegistry.ITEMS.register(bus);
        BlockRegistry.BLOCKS.register(bus);
        ATTACHMENT_TYPES.register(bus);
        CommonMod.RegisterFatties.init();
        CommonMod.Models.LOADER_SPECIFIC_MODEL = () -> Minecraft.getInstance().getModelManager().getModel(CommonMod.Models.TABLECLOTH_MODEL);
        bus.addListener(this::addToCreativeTab);
    }

    public void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        var foodflag = event.getTabKey().equals(CreativeModeTabs.FOOD_AND_DRINKS);
        var decoFlag = event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS);
        if (foodflag || decoFlag) {
            ItemRegistry.ITEMS.getEntries().forEach(itemDeferredHolder -> {
                var isClothFlag = itemDeferredHolder.getRegisteredName().contains("cloth");
                if (!isClothFlag && foodflag || isClothFlag && decoFlag)
                    event.accept(itemDeferredHolder.get());
            });
        }
    }
}
