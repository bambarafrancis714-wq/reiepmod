package net.rayeps.reiepmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rayeps.reiepmod.ReiepMod;

import java.util.List;

public class ModItems {
    public static final Item SUNSTONE_GEM = registerItem("sunstone_gem", new Item(new Item.Settings()));
    public static final Item BURNED_WASTES = registerItem("burned_wastes", new Item(new Item.Settings()));
    public static final Item SOLAR_ENERGY = registerItem("solar_energy", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.reiepmod.solar_energy.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item CLASS = registerItem("class", new Item(new Item.Settings()));
    public static final Item CLASS_CATALYST = registerItem("class_catalyst", new Item(new Item.Settings()));
    public static final Item CLASS_BAR = registerItem("class_bar", new Item(new Item.Settings()));
    public static final Item SUNSTEEL_INGOT = registerItem("sunsteel_ingot", new Item(new Item.Settings()));
    public static final Item PURE_CATALYST = registerItem("pure_catalyst", new Item(new Item.Settings()));

    public static final Item CLASS_SWORD = registerItem("class_sword",
            new SwordItem(ModToolMaterials.CLASS, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.CLASS, 3, -2.8f))));

    public static final Item CLASS_PICKAXE = registerItem("class_pickaxe",
            new PickaxeItem(ModToolMaterials.CLASS, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.CLASS, 1, -2.8f))));

    public static final Item CLASS_AXE = registerItem("class_axe",
            new AxeItem(ModToolMaterials.CLASS, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.CLASS, 5, -3.2f))));

    public static final Item CLASS_SHOVEL = registerItem("class_shovel",
            new ShovelItem(ModToolMaterials.CLASS, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.CLASS, 1.5f, -3.0f))));

    public static final Item CLASS_HOE = registerItem("class_hoe",
            new HoeItem(ModToolMaterials.CLASS, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.CLASS, 0, -3f))));

    public static final Item CLASS_HELMET = registerItem("class_helmet",
    new ArmorItem(ModArmorMaterials.CLASS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25))));

    public static final Item CLASS_CHESTPLATE = registerItem("class_chestplate",
            new ArmorItem(ModArmorMaterials.CLASS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item CLASS_LEGGINGS = registerItem("class_leggings",
            new ArmorItem(ModArmorMaterials.CLASS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));

    public static final Item CLASS_BOOTS = registerItem("class_boots",
            new ArmorItem(ModArmorMaterials.CLASS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReiepMod.MOD_ID, name), item);
    }


    public static void registeredModItems() {
        ReiepMod.LOGGER.info("Registering Mod Items for " + ReiepMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUNSTONE_GEM);
            entries.add(BURNED_WASTES);
            entries.add(SOLAR_ENERGY);
            entries.add(CLASS);
            entries.add(CLASS_BAR);
            entries.add(CLASS_CATALYST);
            entries.add(SUNSTEEL_INGOT);
            entries.add(PURE_CATALYST);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CLASS_SWORD);
            entries.add(CLASS_AXE);
            entries.add(CLASS_PICKAXE);
            entries.add(CLASS_SHOVEL);
            entries.add(CLASS_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(CLASS_SWORD);
            entries.add(CLASS_AXE);
        });
    }

}
