package net.rayeps.reiepmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.rayeps.reiepmod.block.ModBlocks;
import net.rayeps.reiepmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUNSTONE_GEM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ASHES_CHUNK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNED_WASTES_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BURNED_WASTES_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLASS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLASS_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLASS_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLASS_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SUNSTONE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BURNED_WASTES, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLAR_ENERGY   , Models.GENERATED);
        itemModelGenerator.register(ModItems.CLASS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLASS_CATALYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLASS_BAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNSTEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_CATALYST, Models.GENERATED);

        itemModelGenerator.register(ModItems.CLASS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLASS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLASS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLASS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CLASS_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLASS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLASS_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLASS_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CLASS_BOOTS));


    }
}
