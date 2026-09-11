package net.rayeps.reiepmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.rayeps.reiepmod.ReiepMod;

public class ModBlocks {

    public static final Block SUNSTONE_GEM_BLOCK = registerBlock("sunstone_gem_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.LODESTONE)));

    public static final Block ASHES_CHUNK_BLOCK = registerBlock("ashes_chunk_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 3),
                    AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)));

    public static final Block BURNED_WASTES_ORE = registerBlock("burned_wastes_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block BURNED_WASTES_DEEPSLATE_ORE = registerBlock("burned_wastes_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));



    public static final Block BURNED_WASTES_NETHER_ORE = registerBlock("burned_wastes_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block CLASS_ORE = registerBlock("class_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block CLASS_NETHER_ORE = registerBlock("class_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block CLASS_END_ORE = registerBlock("class_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block CLASS_BLOCK = registerBlock("class_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ReiepMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ReiepMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ReiepMod.LOGGER.info("Registering Mod Blocks for " + ReiepMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.ASHES_CHUNK_BLOCK);
            entries.add(ModBlocks.BURNED_WASTES_ORE);
            entries.add(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE);
            entries.add(BURNED_WASTES_NETHER_ORE);
            entries.add(CLASS_ORE);
            entries.add(CLASS_NETHER_ORE);
            entries.add(CLASS_END_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SUNSTONE_GEM_BLOCK);
        });
    }
}
