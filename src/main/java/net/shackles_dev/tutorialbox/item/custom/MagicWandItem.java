package net.shackles_dev.tutorialbox.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class MagicWandItem extends Item {
    public static final Map<Block, Block> LIFE_MAP =
            Map.of(
                    Blocks.STONE, Blocks.INFESTED_STONE,
                    Blocks.COBBLESTONE, Blocks.INFESTED_COBBLESTONE,
                    Blocks.DEEPSLATE, Blocks.INFESTED_DEEPSLATE,
                    Blocks.CHISELED_STONE_BRICKS, Blocks.INFESTED_CHISELED_STONE_BRICKS,
                    Blocks.CRACKED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS,
                    Blocks.MOSSY_STONE_BRICKS, Blocks.INFESTED_MOSSY_STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.INFESTED_STONE_BRICKS
            );
    public static final Map<Block, Block> DEATH_MAP =
            Map.of(
                    Blocks.INFESTED_STONE, Blocks.STONE,
                    Blocks.INFESTED_COBBLESTONE, Blocks.COBBLESTONE,
                    Blocks.INFESTED_DEEPSLATE, Blocks.DEEPSLATE,
                    Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.INFESTED_CRACKED_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS,
                    Blocks.INFESTED_STONE_BRICKS, Blocks.STONE_BRICKS
            );

    public MagicWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(LIFE_MAP.containsKey(clickedBlock)) {
            if(!world.isClient) {
                world.setBlockState(context.getBlockPos(), LIFE_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(2, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_SILVERFISH_HURT, SoundCategory.BLOCKS);
            }
        } else if(DEATH_MAP.containsKey(clickedBlock)) {
            if(!world.isClient) {
                world.setBlockState(context.getBlockPos(), DEATH_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(-1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_WITHER_DEATH, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.magic_wand.tooltip_shift_is_held"));
        } else if(Screen.hasAltDown()) {
            tooltip.add(Text.translatable("item.magic_wand.tooltip_alt_is_held"));
        } else if(Screen.hasControlDown()) {
            tooltip.add(Text.translatable("item.magic_wand.tooltip_ctrl_is_held"));
        } else {
            tooltip.add(Text.translatable("item.magic_wand.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
