package net.shackles_dev.tutorialbox.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.custom.*;
import net.shackles_dev.tutorialbox.sound.ModSounds;

public class ModItems {
    public static final Item LEMON = registerItems("lemon", new LemonItem(new Item.Settings().food(ModFoodComponents.LEMON).recipeRemainder(
            ModItems.CHOPPED_LEMON)));
    public static final Item CHOPPED_LEMON = registerItems("chopped_lemon", new LemonItem(new Item.Settings().food(ModFoodComponents.LEMON)));

    public static final Item CLOUD_BERRIES = registerItems("cloud_berries", new AliasedBlockItem(
            ModBlocks.CLOUD_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.CLOUD_BERRIES)));

    public static final Item WEED = registerItems("weed", new Item(new Item.Settings().food(ModFoodComponents.WEED)));
    public static final Item WEED_SEEDS = registerItems("weed_seeds", new AliasedBlockItem(
            ModBlocks.WEED_CROP, new Item.Settings()));

    public static final Item URANIUM = registerItems("uranium", new Item(new Item.Settings().recipeRemainder(ModItems.URANIUM_WASTE).maxCount(1)));
    public static final Item URANIUM_WASTE = registerItems("uranium_waste", new Item(new Item.Settings()));

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

    public static final Item VOID_SWORD = registerItems("void_sword",
            new SwordItem(ModToolMaterials.VOID, new Item.Settings().attributeModifiers(
                    SwordItem.createAttributeModifiers(ModToolMaterials.VOID, 6, -2.8f))));

    public static final Item VOID_HAMMER = registerItems("void_hammer",
            new VoidHammerItem(ModToolMaterials.VOID, new Item.Settings().attributeModifiers(
                    PickaxeItem.createAttributeModifiers(ModToolMaterials.VOID, 5, -3.6f))));

    public static final Item AMETHYST_BOW = registerItems("amethyst_bow",
            new BowItem(new Item.Settings().maxDamage(600)));


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

    public static final Item BOYKISSER_BOOTS = registerItems("boykisser_boots",
            new ModArmorItem(ModArmorMaterials.BOYKISSER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(
                    ArmorItem.Type.BOOTS.getMaxDamage(5))));

    public static final Item AMETHYST_HORSE_ARMOR = registerItems("amethyst_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.AMETHYST_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().maxCount(1)));

    public static final Item EYEBALL_SMITHING_TEMPLATE = registerItems("eyeball_armor_trim_smithing_template",
            SmithingTemplateItem.of(Identifier.of(TutorialBox.MOD_ID, "eyeball"), FeatureFlags.VANILLA));


    public static final Item DREAMING_STARS_MUSIC_DISC = registerItems("dreaming_stars_music_disc",
            new Item(new Item.Settings().jukeboxPlayable(ModSounds.DREAMING_STARS_KEY).maxCount(1).rarity(Rarity.RARE)));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name), item);
    }

    public static void registerModdedItems() {
        TutorialBox.LOGGER.info("crafting items for " + TutorialBox.MOD_ID + '!');
    }
}
