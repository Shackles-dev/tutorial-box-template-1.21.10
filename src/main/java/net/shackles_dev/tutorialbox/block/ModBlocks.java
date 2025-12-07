package net.shackles_dev.tutorialbox.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.custom.MagicBlock;
import net.shackles_dev.tutorialbox.block.custom.MagicBlockMono;

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
            new MagicBlock(AbstractBlock.Settings.create().nonOpaque())
    );
    public static final Block MAGIC_BLOCK_MONO = registerBlock("magic_block_mono",
            new MagicBlockMono(AbstractBlock.Settings.create().nonOpaque())
    );

    private static Block registerBlock(String name, Block block){
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialBox.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialBox.LOGGER.info("sculpting blocks for " + TutorialBox.MOD_ID);
    }
}
