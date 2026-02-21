package net.shackles_dev.tutorialbox.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent LEMON = new FoodComponent.Builder().nutrition(
            2).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
                    StatusEffects.GLOWING, 90, 5), 100).build();

    public static final FoodComponent JACKDANIELS = new FoodComponent.Builder().nutrition(
            0).saturationModifier(10f).statusEffect(new StatusEffectInstance(
                    StatusEffects.GLOWING, 1200, 5), 100).statusEffect(
                            new StatusEffectInstance(
                    StatusEffects.RESISTANCE, 1200, 20), 100).statusEffect(
                            new StatusEffectInstance(
                    StatusEffects.NAUSEA, 1200, 5), 100).build();

    public static final FoodComponent WEED = new FoodComponent.Builder().nutrition(
            0).saturationModifier(10f).statusEffect(new StatusEffectInstance(
                    StatusEffects.GLOWING, 1200, 5), 100).statusEffect(
                            new StatusEffectInstance(
                    StatusEffects.SLOWNESS, 1200, 2), 100).statusEffect(
                            new StatusEffectInstance(
                    StatusEffects.WEAKNESS, 1200, 2), 100).statusEffect(
                            new StatusEffectInstance(
                    StatusEffects.NAUSEA, 1200, 5), 100).alwaysEdible().build();
}
