package net.rayeps.reiepmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rayeps.reiepmod.item.ModItems;
import net.rayeps.reiepmod.util.ModTags;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.CLASS_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.CLASS_AXE)
                .add(ModItems.CLASS_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.CLASS_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.CLASS_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.CLASS_HOE);

    }
}
