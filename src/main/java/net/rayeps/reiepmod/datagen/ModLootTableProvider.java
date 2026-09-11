package net.rayeps.reiepmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rayeps.reiepmod.block.ModBlocks;
import net.rayeps.reiepmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SUNSTONE_GEM_BLOCK);
        addDrop(ModBlocks.BURNED_WASTES_ORE, oreDrops(ModBlocks.BURNED_WASTES_ORE, ModItems.BURNED_WASTES));
        addDrop(ModBlocks.ASHES_CHUNK_BLOCK, multipleOreDrops(ModBlocks.ASHES_CHUNK_BLOCK, ModItems.BURNED_WASTES, 1, 3));
        addDrop(ModBlocks.BURNED_WASTES_NETHER_ORE, oreDrops(ModBlocks.BURNED_WASTES_NETHER_ORE, ModItems.BURNED_WASTES));
        addDrop(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE, ModItems.BURNED_WASTES, 2, 3));
        addDrop(ModBlocks.CLASS_ORE, oreDrops(ModBlocks.CLASS_ORE, ModItems.CLASS_CATALYST));
        addDrop(ModBlocks.CLASS_NETHER_ORE, oreDrops(ModBlocks.CLASS_NETHER_ORE, ModItems.CLASS_CATALYST));
        addDrop(ModBlocks.CLASS_END_ORE, oreDrops(ModBlocks.CLASS_END_ORE, ModItems.CLASS_CATALYST));
        addDrop(ModBlocks.CLASS_BLOCK);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops((impl.getOrThrow(Enchantments.FORTUNE))))));

    }
}
