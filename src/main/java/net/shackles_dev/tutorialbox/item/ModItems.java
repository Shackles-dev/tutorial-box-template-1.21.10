package net.shackles_dev.tutorialbox.item;

import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.custom.JackDanielsItem;
import net.shackles_dev.tutorialbox.item.custom.MagicWandItem;

import java.util.List;

public class ModItems {
    public static final Item LEMON = registerItems("lemon", new Item(new Item.Settings().food(ModFoodComponents.LEMON).recipeRemainder(ModItems.CHOPPED_LEMON)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("item.lemons.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item CHOPPED_LEMON = registerItems("chopped_lemon", new AliasedBlockItem(ModBlocks.LEMON_LEAVES/*LEMON_SAPLING*/, new Item.Settings().food(ModFoodComponents.CHOPPEDLEMON)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("item.lemons.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item MAGIC_WAND = registerItems("magic_wand", new MagicWandItem(new Item.Settings().maxDamage(128)));
    public static final Item MAGIC_WAND_MONO = registerItems("magic_wand_mono", new MagicWandItem(new Item.Settings().maxDamage(128)));
    public static final Item JACK_DANIELS = registerItems("jack_daniels", new JackDanielsItem(new Item.Settings().food(ModFoodComponents.JACKDANIELS)));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name), item);
    }

    public static void registerModdedItems() {
        TutorialBox.LOGGER.info("crafting items for " + TutorialBox.MOD_ID + '!');
    }
}
