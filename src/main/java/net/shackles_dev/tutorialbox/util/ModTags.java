package net.shackles_dev.tutorialbox.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;

public class ModTags {
    public static class Blocks {

        public static TagKey<Block> createKey(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialBox.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> WANDS = createTag("wands");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialBox.MOD_ID, name));
        }
    }
}
