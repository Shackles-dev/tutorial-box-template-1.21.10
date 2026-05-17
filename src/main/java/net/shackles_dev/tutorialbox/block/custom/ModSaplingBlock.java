package net.shackles_dev.tutorialbox.block.custom;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModSaplingBlock extends SaplingBlock {
    private final Block blockToPlaceOn;

    public ModSaplingBlock(SaplingGenerator generator, Settings settings, Block block) {
        super(generator, settings);
        this.blockToPlaceOn = block;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(this.blockToPlaceOn) || super.canPlantOnTop(floor, world, pos);
    }
}
