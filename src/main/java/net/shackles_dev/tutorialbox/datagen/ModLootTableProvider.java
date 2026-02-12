package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LEMON_PLANKS);
        addDrop(ModBlocks.LEMON_STAIRS);
        addDrop(ModBlocks.LEMON_SLAB, slabDrops(ModBlocks.LEMON_SLAB));
        addDrop(ModBlocks.LEMON_BUTTON);
        addDrop(ModBlocks.LEMON_PRESSURE_PLATE);
        addDrop(ModBlocks.LEMON_DOOR, doorDrops(ModBlocks.LEMON_DOOR));
        addDrop(ModBlocks.LEMON_TRAPDOOR);
        addDrop(ModBlocks.LEMON_FENCE);
        addDrop(ModBlocks.LEMON_FENCE_GATE);
        addDrop(ModBlocks.LEMON_LEAVES, leavesDrops(ModBlocks.LEMON_LEAVES, Block.getBlockFromItem(ModItems.CHOPPED_LEMON), 0.05F, 0.0625F, 0.083333336F, 0.1F));
        //addDrop(ModBlocks.LEMON_LOG);
        //addDrop(ModBlocks.LEMON_SAPLING);
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.CARVED_MELON);
        addDrop(ModBlocks.JACK_O_MELON);
        addDrop(ModBlocks.URANIUM_ORE, oreDrops(ModBlocks.URANIUM_ORE, ModItems.URANIUM));
        addDrop(ModBlocks.DEEPSLATE_URANIUM_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_URANIUM_ORE, ModItems.URANIUM, 3, 5));
        addDrop(Blocks.BUDDING_AMETHYST);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
