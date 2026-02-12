package net.shackles_dev.tutorialbox.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> TOTEM_POTION = registerPotion("totem_potion", new Potion(
            new StatusEffectInstance(ModEffects.TOTEM, 2400, 0)
    ));

    public static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TutorialBox.MOD_ID, name), potion);
    }

    public static void registerModdedPotions() {
        TutorialBox.LOGGER.info("brewing potions for " + TutorialBox.MOD_ID + '!');
    }
}
