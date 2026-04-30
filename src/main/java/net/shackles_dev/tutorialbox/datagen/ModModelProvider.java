package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.block.custom.CloudBerryBushBlock;
import net.shackles_dev.tutorialbox.block.custom.MagicBlock;
import net.shackles_dev.tutorialbox.block.custom.WeedCropBlock;
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
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.LEMON_TRAPDOOR);
        blockStateModelGenerator.registerSingleton(ModBlocks.LEMON_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.LEMON_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerLog(ModBlocks.LEMON_LOG).log(ModBlocks.LEMON_LOG).wood(ModBlocks.LEMON_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_LEMON_LOG).log(ModBlocks.STRIPPED_LEMON_LOG).wood(ModBlocks.STRIPPED_LEMON_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
 
        TextureMap textureMap = TextureMap.sideEnd(Blocks.MELON);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.CARVED_MELON, textureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.JACK_O_MELON, textureMap);

        blockStateModelGenerator.registerCrop(ModBlocks.WEED_CROP, WeedCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(
                ModBlocks.CLOUD_BERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED, CloudBerryBushBlock.AGE, 0, 1, 2, 3);

        Identifier magicBlockColoredIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.MAGIC_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier magicBlockMonoIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.MAGIC_BLOCK, "_mono", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MAGIC_BLOCK).coordinate(
                BlockStateModelGenerator.createBooleanModelMap(MagicBlock.CLICKED, magicBlockColoredIdentifier, magicBlockMonoIdentifier)));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOPPED_LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEED, Models.GENERATED);

        itemModelGenerator.register(ModItems.URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_WASTE, Models.GENERATED);

        itemModelGenerator.register(ModItems.JACK_DANIELS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_WAND_MONO, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AMETHYST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.VOID_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.AMETHYST_BOOTS));

        //itemModelGenerator.registerArmor(((ArmorItem) ModItems.BOYKISSER_BOOTS));

        itemModelGenerator.register(ModItems.AMETHYST_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.EYEBALL_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.DREAMING_STARS_MUSIC_DISC, Models.GENERATED);
    }
}