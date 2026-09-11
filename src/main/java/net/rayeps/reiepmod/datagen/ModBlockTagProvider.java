package net.rayeps.reiepmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rayeps.reiepmod.block.ModBlocks;
import net.rayeps.reiepmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SUNSTONE_GEM_BLOCK)
                .add(ModBlocks.ASHES_CHUNK_BLOCK)
                .add(ModBlocks.BURNED_WASTES_ORE)
                .add(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE)
                .add(ModBlocks.BURNED_WASTES_NETHER_ORE)
                .add(ModBlocks.CLASS_ORE)
                .add(ModBlocks.CLASS_NETHER_ORE)
                .add(ModBlocks.CLASS_END_ORE)
                .add(ModBlocks.CLASS_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CLASS_ORE)
                .add(ModBlocks.CLASS_NETHER_ORE)
                .add(ModBlocks.CLASS_END_ORE)
                .add(ModBlocks.CLASS_BLOCK);



        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_CLASS_TOOL)
                .add(ModBlocks.BURNED_WASTES_ORE)
                .add(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE)
                .add(ModBlocks.SUNSTONE_GEM_BLOCK)
                .add(ModBlocks.BURNED_WASTES_NETHER_ORE);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_CLASS_TOOL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.NEEDS_CLASS_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_CLASS_TOOL)
                .addOptionalTag(BlockTags.NEEDS_DIAMOND_TOOL);


    }
}
