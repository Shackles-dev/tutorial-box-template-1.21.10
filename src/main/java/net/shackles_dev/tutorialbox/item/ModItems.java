package net.shackles_dev.tutorialbox.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;

public class ModItems {
    public static final Item LEMON = registerItems("lemon", new Item(new Item.Settings()));
    public static final Item CHOPPED_LEMON = registerItems("chopped_lemon", new Item(new Item.Settings()));

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialBox.MOD_ID, name), item);
    }

    public static void registerModdedItems() {
        TutorialBox.LOGGER.info("crafting items for " + TutorialBox.MOD_ID);


    }
}
