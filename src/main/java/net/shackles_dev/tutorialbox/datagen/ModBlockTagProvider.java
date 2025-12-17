package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.LEMON_PLANKS)
            .add(ModBlocks.LEMON_STAIRS)
            .add(ModBlocks.LEMON_SLAB)
            .add(ModBlocks.LEMON_BUTTON)
            .add(ModBlocks.LEMON_PRESSURE_PLATE)
            .add(ModBlocks.LEMON_DOOR)
            .add(ModBlocks.LEMON_TRAPDOOR)
            .add(ModBlocks.LEMON_FENCE)
            .add(ModBlocks.LEMON_FENCE_GATE);

    getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.LEMON_FENCE);
    getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.LEMON_FENCE_GATE);

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);

    getOrCreateTagBuilder(ModTags.Blocks.NEEDS_AMETHYST_TOOL)
            .add(Blocks.BUDDING_AMETHYST)
            .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
