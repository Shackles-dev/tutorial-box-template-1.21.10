package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LEMON_PLANKS);
        addDrop(ModBlocks.LEMON_STAIRS);
        addDrop(ModBlocks.LEMON_SLAB, slabDrops(ModBlocks.LEMON_SLAB));
        addDrop(ModBlocks.LEMON_BUTTON);
        addDrop(ModBlocks.LEMON_PRESSURE_PLATE);
        addDrop(ModBlocks.LEMON_DOOR, doorDrops(ModBlocks.LEMON_DOOR));
        addDrop(ModBlocks.LEMON_TRAPDOOR);
        addDrop(ModBlocks.LEMON_FENCE);
        addDrop(ModBlocks.LEMON_FENCE_GATE);
        addDrop(ModBlocks.LEMON_LEAVES, leavesDrops(ModBlocks.LEMON_LEAVES, Block.getBlockFromItem(ModItems.CHOPPED_LEMON), 100));
        //addDrop(ModBlocks.LEMON_SAPLING);
        addDrop(ModBlocks.MAGIC_BLOCK);
    }
}
