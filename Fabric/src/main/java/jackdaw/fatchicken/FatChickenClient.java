package jackdaw.fatchicken;

import jackdaw.fatchicken.entity.FatChicken;
import jackdaw.fatchicken.entity.FatFish;
import jackdaw.fatchicken.entity.FatPig;
import jackdaw.fatchicken.entity.TableCloth;
import jackdaw.fatchicken.entity.render.chicken.FatChickenModel;
import jackdaw.fatchicken.entity.render.chicken.FatChickenRenderer;
import jackdaw.fatchicken.entity.render.cloth.TableClothRenderer;
import jackdaw.fatchicken.entity.render.fish.FatFishModelLayer;
import jackdaw.fatchicken.entity.render.fish.FatFishRenderer;
import jackdaw.fatchicken.entity.render.pig.FatPigModel;
import jackdaw.fatchicken.entity.render.pig.FatPigRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;

public class FatChickenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(CommonMod.Models.TABLECLOTH));

        EntityRendererRegistry.register((EntityType<FatChicken>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_CHICKEN), FatChickenRenderer::new);
        EntityRendererRegistry.register((EntityType<FatPig>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_PIG), FatPigRenderer::new);
        EntityRendererRegistry.register((EntityType<FatFish>) Registry.ENTITY_TYPE.get(CommonMod.Entity.FAT_FISH), FatFishRenderer::new);
        EntityRendererRegistry.register((EntityType<TableCloth>) Registry.ENTITY_TYPE.get(CommonMod.Entity.TABLE_CLOTH_ENTITY), TableClothRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.CHICKEN_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.PIG_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.FISH_BLOCK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CommonMod.Blocks.ICE_CREAM_LOG, RenderType.cutout());

        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATCHICKEN, FatChickenModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATPIG, FatPigModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CommonMod.Models.FATFISH, FatFishModelLayer::createBodyLayer);
    }
}
