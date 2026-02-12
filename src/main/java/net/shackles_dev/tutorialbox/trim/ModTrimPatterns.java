package net.shackles_dev.tutorialbox.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.item.ModItems;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> EYEBALL = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(TutorialBox.MOD_ID, "eyeball"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.EYEBALL_SMITHING_TEMPLATE, EYEBALL);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}
