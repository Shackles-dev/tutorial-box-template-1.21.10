package net.shackles_dev.tutorialbox.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore_placed");

    public static final RegistryKey<PlacedFeature> LEMON_TREE_PLACED_KEY = registerKey("lemon_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.URANIUM_ORE_KEY), ModOrePlacement.modifiersWithCount(
                        5, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
                );

        register(context, LEMON_TREE_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.LEMON_TREE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.LEMON_SAPLING));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TutorialBox.MOD_ID, name));
    }

    private static void register(
            Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
