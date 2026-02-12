package net.shackles_dev.tutorialbox.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.enchantment.custom.RepugnantEnchantmentEffect;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> REPUGNANT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(TutorialBox.MOD_ID, "repugnant"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, REPUGNANT, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE), items.getOrThrow(
                        ItemTags.SWORD_ENCHANTABLE), 5, 2, Enchantment.leveledCost(
                                5, 3), Enchantment.leveledCost(
                                        10, 6), 2, AttributeModifierSlot.MAINHAND)).addEffect(
                EnchantmentEffectComponentTypes.TICK, new RepugnantEnchantmentEffect()
        ));
    }

    public static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }

    public static void registerModdedEnchantments() {
        TutorialBox.LOGGER.info("scripting the enchantments for " + TutorialBox.MOD_ID + '!');
    }
}
