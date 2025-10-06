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
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.FabricBakedModelManager;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;

public class FatChickenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingPlugin.register(context -> context.addModels(CommonMod.Models.TABLECLOTH_RESLOC));
        CommonMod.Models.LOADER_SPECIFIC_MODEL = () -> ((FabricBakedModelManager) Minecraft.getInstance().getModelManager()).getModel(CommonMod.Models.TABLECLOTH_RESLOC);

        EntityRendererRegistry.register(FatChickenEntities.FAT_CHICKEN_ENTITY_TYPE, FatChickenRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.FAT_PIG_ENTITY_TYPE, FatPigRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.FAT_FISH_ENTITY_TYPE, FatFishRenderer::new);
        EntityRendererRegistry.register(FatChickenEntities.CLOTHTYPE, TableClothRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.CHICKEN_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.PIG_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.FISH_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.ICE_CREAM_LOG, RenderType.cutout());

        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATCHICKEN, FatChickenModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATPIG, FatPigModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATFISH, FatFishModelLayer::createBodyLayer);
    }
}
