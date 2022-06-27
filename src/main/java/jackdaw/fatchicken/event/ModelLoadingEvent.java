package jackdaw.fatchicken.event;

import jackdaw.fatchicken.FatChickenMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Bus.MOD)
public class ModelLoadingEvent {

    public static final ResourceLocation TABLECLOTH = new ResourceLocation(FatChickenMod.MODID, "block/tablecloth");

    @SubscribeEvent
    public static void registerItemModel(ModelRegistryEvent event) {
        ForgeModelBakery.addSpecialModel(TABLECLOTH);
    }
}
