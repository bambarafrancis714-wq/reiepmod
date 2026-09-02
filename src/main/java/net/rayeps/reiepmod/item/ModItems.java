package net.rayeps.reiepmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rayeps.reiepmod.ReiepMod;

public class ModItems {
    public static final Item SUNSTONE_GEM = registerItem("sunstone_gem", new Item(new Item.Settings()));
    public static final Item BURNED_WASTES = registerItem("burned_wastes", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ReiepMod.MOD_ID, name), item);
    }


    public static void registeredModItems() {
        ReiepMod.LOGGER.info("Registering Mod Items for " + ReiepMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SUNSTONE_GEM);
            entries.add(BURNED_WASTES);
        });
    }

}
