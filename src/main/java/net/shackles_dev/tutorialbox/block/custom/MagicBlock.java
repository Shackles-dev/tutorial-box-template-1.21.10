package net.shackles_dev.tutorialbox.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shackles_dev.tutorialbox.item.ModItems;
import net.shackles_dev.tutorialbox.sound.ModSounds;
import net.shackles_dev.tutorialbox.util.ModTags;

import java.util.List;

public class MagicBlock extends Block{
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public MagicBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CLICKED, true));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, ModSounds.MAGIC_BLOCK_USE, SoundCategory.BLOCKS, 10f, 1f);
        if(!world.isClient) {
            world.setBlockState(pos, state.cycle(CLICKED));
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity item) {
            if(isValidItem(item.getStack())) {
                if(state.get(CLICKED)) {
                    item.setStack(new ItemStack(ModItems.MAGIC_WAND, item.getStack().getCount()));
                } else {
                    item.setStack(new ItemStack(ModItems.MAGIC_WAND_MONO, item.getStack().getCount()));
                }
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.WANDS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("block.magic_block.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}