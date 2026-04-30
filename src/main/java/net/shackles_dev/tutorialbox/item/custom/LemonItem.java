package net.shackles_dev.tutorialbox.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.shackles_dev.tutorialbox.item.ModItems;

import java.util.List;

public class LemonItem extends Item {

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.lemons.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

            if(stack.isEmpty()) {
                return new ItemStack(ModItems.CHOPPED_LEMON);
            } else {
                if(user instanceof PlayerEntity playerEntity && !playerEntity.isInCreativeMode()) {
                    ItemStack itemStack = new ItemStack(ModItems.CHOPPED_LEMON);
                    if(!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }

                return stack;
            }
    }

    public LemonItem(Settings settings) {
        super(settings);
    }
}
