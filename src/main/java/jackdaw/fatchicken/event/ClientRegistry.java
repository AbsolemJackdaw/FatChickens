package jackdaw.fatchicken.event;


import jackdaw.fatchicken.FatChickenMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenRenderer;
import jackdaw.fatchicken.entity.render.fish.FatFishRenderer;
import jackdaw.fatchicken.entity.render.pig.FatPigRenderer;
import jackdaw.fatchicken.entity.render.cloth.TableClothRenderer;
import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.EntityRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        EntityRenderers.register(EntityRegistry.FAT_FISH.get(), FatFishRenderer::new);
        EntityRenderers.register(EntityRegistry.TABLECLOTH.get(), TableClothRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CAKE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATFISH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATPIG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATCHICKEN.get(), RenderType.cutout());

    }
}