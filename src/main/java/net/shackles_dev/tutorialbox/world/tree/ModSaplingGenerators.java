package net.shackles_dev.tutorialbox.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator LEMON_TREE = new SaplingGenerator(TutorialBox.MOD_ID + ":lemon_tree", Optional.empty(
            ), Optional.of(ModConfiguredFeatures.LEMON_TREE_KEY), Optional.empty());
}
