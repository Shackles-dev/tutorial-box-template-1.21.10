package net.shackles_dev.tutorialbox.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.enchantment.custom.RepugnantEnchantmentEffect;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> REPUGNANT =
            registerEntityEffect("repugnant", RepugnantEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(
            String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(TutorialBox.MOD_ID, name), codec);
    }

    public static void registerModdedEnchantmentEffects() {
        TutorialBox.LOGGER.info("testing the enchantments for " + TutorialBox.MOD_ID + '!');
    }
}
