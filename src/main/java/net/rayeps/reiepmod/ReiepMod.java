package net.rayeps.reiepmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import net.rayeps.reiepmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReiepMod implements ModInitializer {
	public static final String MOD_ID = "reiepmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registeredModItems();

	}
}
