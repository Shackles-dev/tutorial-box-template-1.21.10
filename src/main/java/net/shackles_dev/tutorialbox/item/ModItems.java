package net.shackles_dev.tutorialbox.item;

import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.custom.HammerItem;
import net.shackles_dev.tutorialbox.item.custom.JackDanielsItem;
import net.shackles_dev.tutorialbox.item.custom.MagicWandItem;
import net.shackles_dev.tutorialbox.item.custom.ModArmorItem;

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


    public static final Item AMETHYST_SWORD = registerItems("amethyst_sword",
            new SwordItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 3, -2.4f))));

    public static final Item AMETHYST_PICKAXE = registerItems("amethyst_pickaxe",
            new PickaxeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 1, -2.8f))));

    public static final Item AMETHYST_SHOVEL = registerItems("amethyst_shovel",
            new ShovelItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    ShovelItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 1.5f, -3.0f))));

    public static final Item AMETHYST_AXE = registerItems("amethyst_axe",
            new AxeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    AxeItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 6, -3.2f))));

    public static final Item AMETHYST_HOE = registerItems("amethyst_hoe",
            new HoeItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    HoeItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 0, -3.0f))));

    public static final Item AMETHYST_HAMMER = registerItems("amethyst_hammer",
            new HammerItem(ModToolMaterials.AMETHYST, new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ModToolMaterials.AMETHYST, 5, -3.6f))));


    public static final Item AMETHYST_HELMET = registerItems("amethyst_helmet",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(
                    ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item AMETHYST_CHESTPLATE = registerItems("amethyst_chestplate",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(
                    ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item AMETHYST_LEGGINGS = registerItems("amethyst_leggings",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(
                    ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item AMETHYST_BOOTS = registerItems("amethyst_boots",
            new ModArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(
                    ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item AMETHYST_HORSE_ARMOR = registerItems("amethyst_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().maxCount(1)));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name), item);
    }

    public static void registerModdedItems() {
        TutorialBox.LOGGER.info("crafting items for " + TutorialBox.MOD_ID + '!');
    }
}
