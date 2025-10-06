package jackdaw.fatchicken.event;


import jackdaw.fatchicken.CommonMod;
import jackdaw.fatchicken.entity.render.chicken.FatChickenRenderer;
import jackdaw.fatchicken.entity.render.cloth.TableClothRenderer;
import jackdaw.fatchicken.entity.render.fish.FatFishRenderer;
import jackdaw.fatchicken.entity.render.pig.FatPigRenderer;
import jackdaw.fatchicken.registry.BlockRegistry;
import jackdaw.fatchicken.registry.FatChickenEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = CommonMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {

        EntityRenderers.register(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, FatChickenRenderer::new);
        EntityRenderers.register(FatChickenEntities.FAT_PIG_ENTITY_TYPE, FatPigRenderer::new);
        EntityRenderers.register(FatChickenEntities.FAT_FISH_ENTITY_TYPE, FatFishRenderer::new);
        EntityRenderers.register(FatChickenEntities.CLOTHTYPE, TableClothRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CAKE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATFISH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATPIG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FATCHICKEN.get(), RenderType.cutout());

    }
}