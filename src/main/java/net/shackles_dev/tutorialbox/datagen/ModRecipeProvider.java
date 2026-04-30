package net.shackles_dev.tutorialbox.datagen;


import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.shackles_dev.tutorialbox.TutorialBox;
import net.shackles_dev.tutorialbox.block.ModBlocks;
import net.shackles_dev.tutorialbox.item.ModItems;


import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider{

    private static final ImmutableList<ItemConvertible> URANIUM_ORES = ImmutableList.of(ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHOPPED_LEMON, 2)
                .input(ModItems.LEMON)
                .criterion(hasItem(ModItems.LEMON), conditionsFromItem(ModItems.LEMON))
                .offerTo(recipeExporter, Identifier.of(TutorialBox.MOD_ID, "chopped_lemon_from_lemon"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.YELLOW_DYE, 1)
                .input(ModItems.CHOPPED_LEMON)
                .criterion(hasItem(ModItems.LEMON), conditionsFromItem(ModItems.LEMON))
                .offerTo(recipeExporter, Identifier.of(TutorialBox.MOD_ID, "yellow_dye_from_chopped_lemon"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_SWORD)
                .input('#', Items.AMETHYST_SHARD)
                .input('-', Items.AMETHYST_CLUSTER)
                .input('|', Items.STICK)
                .pattern(" # ")
                .pattern(" - ")
                .pattern(" | ")
                .criterion("has amethyst", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_PICKAXE)
                .input('#', Items.AMETHYST_SHARD)
                .input('-', Items.SMALL_AMETHYST_BUD)
                .input('|', Items.STICK)
                .pattern("-#-")
                .pattern(" | ")
                .pattern(" | ")
                .criterion("has amethyst", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_SHOVEL)
                .input('#', Items.AMETHYST_CLUSTER)
                .input('|', Items.STICK)
                .pattern(" # ")
                .pattern(" | ")
                .pattern(" | ")
                .criterion("has amethyst", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_AXE)
                .input('/', Items.AMETHYST_SHARD)
                .input('#', Items.AMETHYST_CLUSTER)
                .input('|', Items.STICK)
                .pattern(" /#")
                .pattern(" /|")
                .pattern("  |")
                .criterion("has amethyst", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.AMETHYST_HOE)
                .input('/', Items.AMETHYST_SHARD)
                .input('#', Items.AMETHYST_CLUSTER)
                .input('|', Items.STICK)
                .pattern("/# ")
                .pattern(" | ")
                .pattern(" | ")
                .criterion("has amethyst", conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_BLOCK)
                .input('#', ModItems.URANIUM)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .criterion("has uranium", conditionsFromItem(ModItems.URANIUM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.URANIUM_GLASS)
                .input('#', ModItems.URANIUM)
                .input('*', Blocks.GLASS)
                .pattern(" # ")
                .pattern("#*#")
                .pattern(" # ")
                .criterion("has uranium", conditionsFromItem(ModItems.URANIUM))
                .offerTo(recipeExporter);



        offerSmithingTrimRecipe(recipeExporter, ModItems.EYEBALL_SMITHING_TEMPLATE, Identifier.of(TutorialBox.MOD_ID, "eyeball"));

        offerSmelting(recipeExporter, URANIUM_ORES, RecipeCategory.MISC, ModItems.URANIUM, 6.0F, 200, "uranium_ores");
        offerBlasting(recipeExporter, URANIUM_ORES, RecipeCategory.MISC, ModItems.URANIUM, 6.0F, 100, "uranium_ores");
    }
}
