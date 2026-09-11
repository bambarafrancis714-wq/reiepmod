package net.rayeps.reiepmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rayeps.reiepmod.ReiepMod;
import net.rayeps.reiepmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup SUN_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReiepMod.MOD_ID, "sun_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SUNSTONE_GEM))
                    .displayName(Text.translatable("itemgroup.reiepmod.sun_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SUNSTONE_GEM);
                        entries.add(ModItems.BURNED_WASTES);
                        entries.add(ModItems.SOLAR_ENERGY);
                        entries.add(ModItems.SUNSTEEL_INGOT);
                    })
                    .build());


    public static final ItemGroup SUN_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReiepMod.MOD_ID, "sun_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SUNSTONE_GEM_BLOCK))
                    .displayName(Text.translatable("itemgroup.reiepmod.sun_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SUNSTONE_GEM_BLOCK);
                        entries.add(ModBlocks.ASHES_CHUNK_BLOCK);
                        entries.add(ModBlocks.BURNED_WASTES_ORE);
                        entries.add(ModBlocks.BURNED_WASTES_DEEPSLATE_ORE);
                        entries.add(ModBlocks.BURNED_WASTES_NETHER_ORE);
                    })
                    .build());



    public static final ItemGroup CLASS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ReiepMod.MOD_ID, "class"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CLASS))
                    .displayName(Text.translatable("itemgroup.reiepmod.class"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CLASS);
                        entries.add(ModItems.CLASS_CATALYST);
                        entries.add(ModItems.CLASS_BAR);
                        entries.add(ModItems.PURE_CATALYST);
                        entries.add(ModBlocks.CLASS_ORE);
                        entries.add(ModBlocks.CLASS_NETHER_ORE);
                        entries.add(ModBlocks.CLASS_END_ORE);
                        entries.add(ModBlocks.CLASS_BLOCK);
                        entries.add(ModItems.CLASS_SWORD);
                        entries.add(ModItems.CLASS_PICKAXE);
                        entries.add(ModItems.CLASS_AXE);
                        entries.add(ModItems.CLASS_SHOVEL);
                        entries.add(ModItems.CLASS_HOE);
                        entries.add(ModItems.CLASS_HELMET);
                        entries.add(ModItems.CLASS_CHESTPLATE);
                        entries.add(ModItems.CLASS_LEGGINGS);
                        entries.add(ModItems.CLASS_BOOTS);
                    })
                    .build());




    public static void registerItemGroups() {
        ReiepMod.LOGGER.info("Registering Item Groups for " + ReiepMod.MOD_ID);
    }
}
