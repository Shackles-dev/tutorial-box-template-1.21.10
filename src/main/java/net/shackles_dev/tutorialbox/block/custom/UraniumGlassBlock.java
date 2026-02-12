package net.shackles_dev.tutorialbox.block.custom;

import net.minecraft.block.TransparentBlock;

public class UraniumGlassBlock extends TransparentBlock {
    public UraniumGlassBlock(Settings settings) {
        super(settings.luminance(state -> 6));
    }
}
