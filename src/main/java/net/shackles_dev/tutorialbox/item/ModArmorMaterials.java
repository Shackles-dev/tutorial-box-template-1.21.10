package net.shackles_dev.tutorialbox.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.shackles_dev.tutorialbox.TutorialBox;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> AMETHYST_ARMOR_MATERIAL = registerArmorMaterial("amethyst", () ->
            new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 9);
            }), 25, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> Ingredient.ofItems(Items.AMETHYST_SHARD),
                    List.of(new ArmorMaterial.Layer(Identifier.of(TutorialBox.MOD_ID, "amethyst"))), 0, 0));

    public static final RegistryEntry<ArmorMaterial> BOYKISSER_ARMOR_MATERIAL = registerArmorMaterial("boykisser", () ->
            new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 3);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(Items.WHITE_DYE, Items.PINK_DYE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(TutorialBox.MOD_ID,"boykisser"), "", false), new ArmorMaterial.Layer(Identifier.of(TutorialBox.MOD_ID,"boykisser"), "_overlay", true)), 0, 0));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(TutorialBox.MOD_ID, name), material.get());
    }
}