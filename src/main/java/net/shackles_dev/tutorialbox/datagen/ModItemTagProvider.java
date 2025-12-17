package net.shackles_dev.tutorialbox.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.shackles_dev.tutorialbox.item.ModItems;
import net.shackles_dev.tutorialbox.util.ModTags;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.WANDS)
                .add(ModItems.MAGIC_WAND)
                .add(ModItems.MAGIC_WAND_MONO)
                .add(Items.DEBUG_STICK);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.AMETHYST_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.AMETHYST_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.AMETHYST_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.AMETHYST_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.AMETHYST_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AMETHYST_HELMET)
                .add(ModItems.AMETHYST_CHESTPLATE)
                .add(ModItems.AMETHYST_LEGGINGS)
                .add(ModItems.AMETHYST_BOOTS);
    }
}
