package jackdaw.fatchicken;

import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.chicken.FatChickenRenderer;
import jackdaw.fatchicken.entity.render.cloth.TableClothRenderer;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.fish.FatFishRenderer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import jackdaw.fatchicken.entity.render.pig.FatPigRenderer;
import jackdaw.fatchicken.registry.FatChickenEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class FatChickenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        ModelLoadingPlugin.register(context -> context.addModels(CommonMod.Models.TABLECLOTH_RESLOC));
//        CommonMod.Models.LOADER_SPECIFIC_MODEL = () -> ((FabricBakedModelManager) Minecraft.getInstance().getModelManager()).getModel(CommonMod.Models.TABLECLOTH_RESLOC);

        EntityRendererRegistry.register(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, FatChickenRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.FAT_PIG_ENTITY_TYPE, FatPigRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.FAT_FISH_ENTITY_TYPE, FatFishRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.CLOTHTYPE, TableClothRenderer::new);

        BlockRenderLayerMap.putBlock(CommonMod.Blocks.CHICKEN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(CommonMod.Blocks.PIG, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(CommonMod.Blocks.FISH, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(CommonMod.Blocks.ICE_CREAM_LOG, ChunkSectionLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.CHICKEN, FatChickenModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.PIG, FatPigModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FISH, FatFishModelLayer::createBodyLayer);
    }
}
