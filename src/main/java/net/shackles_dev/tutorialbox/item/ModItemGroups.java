package net.shackles_dev.tutorialbox.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModItemGroups {
    public static final ItemGroup MODDED_FOODS_AND_DRINKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_food_and_drinks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LEMON)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_food_and_drinks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.LEMON);
                                entries.add(ModItems.CHOPPED_LEMON);
                                entries.add(ModItems.JACK_DANIELS);
                                entries.add(ModItems.WEED);
                                entries.add(ModItems.CLOUD_BERRIES);
                            }).build());
    public static final ItemGroup MODDED_NATURAL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_natural_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEMON_LEAVES)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_natural_blocks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModBlocks.LEMON_LOG);
                                entries.add(ModBlocks.LEMON_LEAVES);
                                entries.add(ModBlocks.LEMON_SAPLING);

                                entries.add(ModBlocks.URANIUM_ORE);
                                entries.add(ModBlocks.DEEPSLATE_URANIUM_ORE);
                                entries.add(ModBlocks.URANIUM_BLOCK);

                                entries.add(ModBlocks.CARVED_MELON);
                                entries.add(ModBlocks.JACK_O_MELON);

                                entries.add(ModItems.WEED_SEEDS);
                            }).build());
    public static final ItemGroup MODDED_BUILDING_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_building_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEMON_PLANKS)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_building_blocks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModBlocks.LEMON_LOG);
                                entries.add(ModBlocks.LEMON_PLANKS);
                                entries.add(ModBlocks.LEMON_WOOD);
                                entries.add(ModBlocks.STRIPPED_LEMON_LOG);
                                entries.add(ModBlocks.STRIPPED_LEMON_WOOD);
                                entries.add(ModBlocks.LEMON_STAIRS);
                                entries.add(ModBlocks.LEMON_SLAB);
                                entries.add(ModBlocks.LEMON_FENCE);
                                entries.add(ModBlocks.LEMON_FENCE_GATE);
                                entries.add(ModBlocks.LEMON_BUTTON);
                                entries.add(ModBlocks.LEMON_PRESSURE_PLATE);
                                entries.add(ModBlocks.LEMON_DOOR);
                                entries.add(ModBlocks.LEMON_TRAPDOOR);
                                entries.add(ModBlocks.MAGIC_BLOCK);
                            }).build());
    public static final ItemGroup MODDED_COLORED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_colored_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.URANIUM_GLASS)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_colored_blocks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModBlocks.URANIUM_GLASS);
                            }).build());
    public static final ItemGroup MODDED_TOOLS_AND_UTILITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_tools_and_utilities"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGIC_WAND)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_tools_and_utilities")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.MAGIC_WAND);

                                entries.add(ModItems.JACK_DANIELS);

                                entries.add(ModItems.AMETHYST_PICKAXE);
                                entries.add(ModItems.AMETHYST_SHOVEL);
                                entries.add(ModItems.AMETHYST_AXE);
                                entries.add(ModItems.AMETHYST_HOE);
                                entries.add(ModItems.AMETHYST_HAMMER);

                                entries.add(ModItems.VOID_HAMMER);

                                entries.add(ModItems.DREAMING_STARS_MUSIC_DISC);
                            }).build());
    public static final ItemGroup MODDED_COMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_combat"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.AMETHYST_SWORD)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_combat")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.MAGIC_WAND);

                                entries.add(ModItems.AMETHYST_SWORD);
                                entries.add(ModItems.AMETHYST_AXE);
                                entries.add(ModItems.AMETHYST_HAMMER);
                                entries.add(ModItems.AMETHYST_BOW);

                                entries.add(ModItems.VOID_SWORD);
                                entries.add(ModItems.VOID_HAMMER);

                                entries.add(ModItems.AMETHYST_HELMET);
                                entries.add(ModItems.AMETHYST_CHESTPLATE);
                                entries.add(ModItems.AMETHYST_LEGGINGS);
                                entries.add(ModItems.AMETHYST_BOOTS);

                                entries.add(ModItems.BOYKISSER_BOOTS);

                                entries.add(ModItems.AMETHYST_HORSE_ARMOR);
                            }).build());
    public static final ItemGroup INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "ingredients"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.URANIUM)).displayName(
                    Text.translatable("itemGroup.tutorialbox.ingredients")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.EYEBALL_SMITHING_TEMPLATE);

                                entries.add(ModItems.URANIUM);
                                entries.add(ModItems.URANIUM_WASTE);
                            }).build());
    private static final Logger log = LoggerFactory.getLogger(ModItemGroups.class);


    public static void registerItemGroups() {
        TutorialBox.LOGGER.info("making room for creations in " + TutorialBox.MOD_ID + '!');
    }
}