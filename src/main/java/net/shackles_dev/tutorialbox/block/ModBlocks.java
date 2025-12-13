package net.shackles_dev.tutorialbox.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.custom.MagicBlock;

public class ModBlocks {
    //public static final Block LEMON_LOG = registerBlock("lemon_log",
    //         new Block(AbstractBlock.Settings.create().burnable())
    // );
    public static final Block LEMON_PLANKS = registerBlock("lemon_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.YELLOW))
    );
    public static final Block LEMON_LEAVES = registerBlock("lemon_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES))
    );

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().nonOpaque().luminance(state -> state.get(MagicBlock.CLICKED) ? 15 : 0))
    );

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
