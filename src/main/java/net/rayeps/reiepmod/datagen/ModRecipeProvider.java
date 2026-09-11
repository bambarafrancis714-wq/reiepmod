package net.rayeps.reiepmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.rayeps.reiepmod.ReiepMod;
import net.rayeps.reiepmod.block.ModBlocks;
import net.rayeps.reiepmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> SUNSTONE_GEM_SMELTABLES = List.of(ModItems.BURNED_WASTES, ModBlocks.BURNED_WASTES_ORE,
                ModBlocks.BURNED_WASTES_DEEPSLATE_ORE, ModBlocks.BURNED_WASTES_NETHER_ORE);

        offerSmelting(exporter, SUNSTONE_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.SUNSTONE_GEM, 0.25f,
                200, "sunstone_gem");

        offerBlasting(exporter, SUNSTONE_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.SUNSTONE_GEM, 0.25f,
                100, "sunstone_gem");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SUNSTONE_GEM,
                RecipeCategory.MISC, ModBlocks.SUNSTONE_GEM_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CLASS,
                RecipeCategory.MISC, ModBlocks.CLASS_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLAR_ENERGY, 4)
                .pattern(" # ")
                .pattern("#S#")
                .pattern(" C ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('S', ModItems.SUNSTONE_GEM)
                .input('C', Items.DRAGON_BREATH)
                .criterion(hasItem(ModItems.SUNSTONE_GEM), conditionsFromItem(ModItems.SUNSTONE_GEM))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLASS_BAR, 2)
                .pattern("C")
                .pattern("C")
                .input('C', ModItems.CLASS)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLASS, 1)
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.CLASS_CATALYST)
                .criterion(hasItem(ModItems.CLASS_CATALYST), conditionsFromItem(ModItems.CLASS_CATALYST))
                .offerTo(exporter, Identifier.of(ReiepMod.MOD_ID, "class_from_class_catalyst"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLASS_SWORD, 1)
                .pattern("  C")
                .pattern("#C ")
                .pattern("B# ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('C', ModItems.CLASS)
                .input('B', ModItems.CLASS_BAR)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CLASS_PICKAXE, 1)
                .pattern("C#C")
                .pattern(" B ")
                .pattern(" B ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('C', ModItems.CLASS)
                .input('B', ModItems.CLASS_BAR)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLASS_AXE, 1)
                .pattern("C#C")
                .pattern("CB ")
                .pattern(" B ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('C', ModItems.CLASS)
                .input('B', ModItems.CLASS_BAR)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CLASS_SHOVEL, 1)
                .pattern(" # ")
                .pattern("CBC")
                .pattern(" B ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('C', ModItems.CLASS)
                .input('B', ModItems.CLASS_BAR)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CLASS_HOE, 1)
                .pattern("CC#")
                .pattern(" B ")
                .pattern(" B ")
                .input('#', ModItems.CLASS_CATALYST)
                .input('C', ModItems.CLASS)
                .input('B', ModItems.CLASS_BAR)
                .criterion(hasItem(ModItems.CLASS), conditionsFromItem(ModItems.CLASS))
                .offerTo(exporter);
    }
}
