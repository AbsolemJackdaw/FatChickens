package be.jackdaw.fatchicken.event;


import be.jackdaw.fatchicken.FatChickenMod;
import be.jackdaw.fatchicken.entity.render.FatChickenRenderer;
import be.jackdaw.fatchicken.entity.render.FatPigRenderer;
import be.jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FatChickenMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {

        EntityRenderers.register(EntityRegistry.FAT_CHICKEN.get(), FatChickenRenderer::new);
        EntityRenderers.register(EntityRegistry.FAT_PIG.get(), FatPigRenderer::new);

    }
}