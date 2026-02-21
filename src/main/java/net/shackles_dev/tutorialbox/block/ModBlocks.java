package net.shackles_dev.tutorialbox.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.custom.MagicBlock;
import net.shackles_dev.tutorialbox.block.custom.UraniumBlock;
import net.shackles_dev.tutorialbox.block.custom.UraniumGlassBlock;
import net.shackles_dev.tutorialbox.block.custom.WeedCropBlock;
import net.shackles_dev.tutorialbox.sound.ModSounds;

import static net.minecraft.block.Blocks.createLogBlock;

public class ModBlocks {
//    public static final Block LEMON_LOG = registerBlock("lemon_log",
//            createLogBlock(MapColor.PALE_YELLOW, MapColor.YELLOW)
//    );
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES))
    );
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.YELLOW))
    );

    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new UraniumBlock(AbstractBlock.Settings.copy(Blocks.EMERALD_ORE))
    );
    public static final Block DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore",
            new UraniumBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_EMERALD_ORE))
    );
    public static final Block URANIUM_GLASS = registerBlock("uranium_glass",
            new UraniumGlassBlock(AbstractBlock.Settings.copy(Blocks.GREEN_STAINED_GLASS))
    );
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new UraniumBlock(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK))
    );

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().nonOpaque().luminance(state -> state.get(
                    MagicBlock.CLICKED) ? 15 : 0).sounds(ModSounds.MAGIC_BLOCK_SOUNDS))
    );

    public static final Block CARVED_MELON = registerBlock("carved_melon",
            new WearableCarvedPumpkinBlock(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN).mapColor(MapColor.GREEN)));

    public static final Block JACK_O_MELON = registerBlock("jack_o_melon",
            new CarvedPumpkinBlock(AbstractBlock.Settings.copy(Blocks.JACK_O_LANTERN).mapColor(MapColor.GREEN)));

    public static final Block LEMON_STAIRS = registerBlock("lemon_stairs",
            new StairsBlock(ModBlocks.LEMON_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.YELLOW))
    );
    public static final Block LEMON_SLAB = registerBlock("lemon_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.YELLOW))
    );

    public static final Block LEMON_BUTTON = registerBlock("lemon_button",
            new ButtonBlock(BlockSetType.OAK, 10,
                    AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.YELLOW))
    );
    public static final Block LEMON_PRESSURE_PLATE = registerBlock("lemon_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.YELLOW))
    );

    public static final Block LEMON_FENCE = registerBlock("lemon_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.YELLOW))
    );
    public static final Block LEMON_FENCE_GATE = registerBlock("lemon_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.YELLOW))
    );

    public static final Block LEMON_DOOR = registerBlock("lemon_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.YELLOW))
    );
    public static final Block LEMON_TRAPDOOR = registerBlock("lemon_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.YELLOW))
    );

//    public static final Block LEMON_SAPLING = registerBlock("lemon_sapling",
//            new SaplingBlock(SaplingGenerator.OAK, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING))
//    );

    public static final Block WEED_CROP = registerBlockOnly("weed_crop",
            new WeedCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT))
    );

    private static Block registerBlockOnly(String name, Block block){
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialBox.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialBox.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialBox.LOGGER.info("sculpting blocks for " + TutorialBox.MOD_ID + '!');
    }
}
