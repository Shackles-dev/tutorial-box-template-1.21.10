package net.shackles_dev.tutorialbox;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.shackles_dev.tutorialbox.block.ModBlocks;

public class TutorialBoxClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEMON_DOOR, RenderLayer.getCutout());
    }
}
