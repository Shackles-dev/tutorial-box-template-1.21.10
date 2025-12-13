package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.block.custom.MagicBlock;
import net.shackles_dev.tutorialbox.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool LemonWoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEMON_PLANKS);
        LemonWoodPool.stairs(ModBlocks.LEMON_STAIRS);
        LemonWoodPool.slab(ModBlocks.LEMON_SLAB);
        LemonWoodPool.button(ModBlocks.LEMON_BUTTON);
        LemonWoodPool.pressurePlate(ModBlocks.LEMON_PRESSURE_PLATE);
        LemonWoodPool.fence(ModBlocks.LEMON_FENCE);
        LemonWoodPool.fenceGate(ModBlocks.LEMON_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.LEMON_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.LEMON_TRAPDOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEMON_LEAVES);

        Identifier magicBlockColoredIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.MAGIC_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier magicBlockMonoIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.MAGIC_BLOCK, "_mono", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MAGIC_BLOCK).coordinate(
                BlockStateModelGenerator.createBooleanModelMap(MagicBlock.CLICKED, magicBlockColoredIdentifier, magicBlockMonoIdentifier)));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOPPED_LEMON, Models.GENERATED);

        itemModelGenerator.register(ModItems.JACK_DANIELS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_WAND, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_WAND_MONO, Models.GENERATED);
    }
}
