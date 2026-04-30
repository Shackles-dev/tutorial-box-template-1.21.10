package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.block.custom.CloudBerryBushBlock;
import net.shackles_dev.tutorialbox.block.custom.WeedCropBlock;
import net.shackles_dev.tutorialbox.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.LEMON_PLANKS);
        addDrop(ModBlocks.LEMON_STAIRS);
        addDrop(ModBlocks.LEMON_SLAB, slabDrops(ModBlocks.LEMON_SLAB));
        addDrop(ModBlocks.LEMON_BUTTON);
        addDrop(ModBlocks.LEMON_PRESSURE_PLATE);
        addDrop(ModBlocks.LEMON_DOOR, doorDrops(ModBlocks.LEMON_DOOR));
        addDrop(ModBlocks.LEMON_TRAPDOOR);
        addDrop(ModBlocks.LEMON_FENCE);
        addDrop(ModBlocks.LEMON_FENCE_GATE);
        addDrop(ModBlocks.LEMON_LEAVES, leavesDrops(ModBlocks.LEMON_LEAVES, ModBlocks.LEMON_SAPLING, 0.05F, 0.0625F, 0.083333336F, 0.1F));
        addDrop(ModBlocks.LEMON_LOG);
        addDrop(ModBlocks.LEMON_WOOD);
        addDrop(ModBlocks.STRIPPED_LEMON_LOG);
        addDrop(ModBlocks.STRIPPED_LEMON_WOOD);
        addDrop(ModBlocks.LEMON_SAPLING);
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.CARVED_MELON);
        addDrop(ModBlocks.JACK_O_MELON);
        addDrop(ModBlocks.URANIUM_ORE, multipleOreDrops(ModBlocks.URANIUM_ORE, ModItems.URANIUM, 2, 5));
        addDrop(ModBlocks.DEEPSLATE_URANIUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_URANIUM_ORE, ModItems.URANIUM, 4, 6));
        addDrop(Blocks.BUDDING_AMETHYST);

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(
                StatePredicate.Builder.create().exactMatch(WeedCropBlock.AGE, WeedCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.WEED_CROP, this.cropDrops(ModBlocks.WEED_CROP, ModItems.WEED, ModItems.WEED_SEEDS, builder2));

        this.addDrop(ModBlocks.CLOUD_BERRY_BUSH, block -> this.applyExplosionDecay(block, LootTable.builder().pool(
                                        LootPool.builder().conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.CLOUD_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(CloudBerryBushBlock.AGE, 3))
                                                ).with(ItemEntry.builder(ModItems.CLOUD_BERRIES)).apply(
                                                        SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))).apply(
                                                                ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                ).pool(LootPool.builder().conditionally(
                                                        BlockStatePropertyLootCondition.builder(ModBlocks.CLOUD_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(CloudBerryBushBlock.AGE, 2))
                                                ).with(ItemEntry.builder(ModItems.CLOUD_BERRIES)).apply(
                                                        SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).apply(
                                                        ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))))
        );
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
