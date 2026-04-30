package net.shackles_dev.tutorialbox.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class LemonSaplingItem extends AliasedBlockItem {

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.lemons.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);
    }

    public LemonSaplingItem(Block block, Settings settings) {
        super(block, settings);
    }
}
