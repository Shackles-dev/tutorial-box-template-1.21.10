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

public class ModItemGroups {
    public static final ItemGroup MODDED_FOODS_AND_DRINKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_food_and_drinks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LEMON)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_food_and_drinks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.LEMON);
                                entries.add(ModItems.CHOPPED_LEMON);
                                entries.add(ModItems.JACK_DANIELS);
                            }).build());
    public static final ItemGroup MODDED_NATURAL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_natural_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEMON_LEAVES)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_natural_blocks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModBlocks.LEMON_LEAVES);
                            }).build());
    public static final ItemGroup MODDED_BUILDING_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_building_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEMON_PLANKS)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_building_blocks")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModBlocks.LEMON_PLANKS);
                                entries.add(ModBlocks.MAGIC_BLOCK);
                            }).build());
    public static final ItemGroup MODDED_TOOLS_AND_UTILITIES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_tools_and_utilities"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGIC_WAND)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_tools_and_utilities")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.MAGIC_WAND);
                                entries.add(ModItems.JACK_DANIELS);
                            }).build());
    public static final ItemGroup MODDED_COMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialBox.MOD_ID, "modded_combat"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MAGIC_WAND)).displayName(
                    Text.translatable("itemGroup.tutorialbox.modded_combat")).entries(
                            (displayContext, entries) -> {
                                entries.add(ModItems.MAGIC_WAND);
                            }).build());


    public static void registerItemGroups() {
        TutorialBox.LOGGER.info("making room for creations in " + TutorialBox.MOD_ID);
    }
}