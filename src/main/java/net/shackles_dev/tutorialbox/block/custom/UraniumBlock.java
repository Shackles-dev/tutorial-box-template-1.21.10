package net.shackles_dev.tutorialbox.block.custom;

import net.minecraft.block.Block;

public class UraniumBlock extends Block {
    public UraniumBlock(Settings settings) {
        super(settings.luminance(state -> 8));
    }
}
