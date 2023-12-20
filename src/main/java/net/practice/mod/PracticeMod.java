package net.practice.mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.practice.mod.Item.ModItemGroup;
import net.practice.mod.Item.ModItems;
import net.practice.mod.block.ModBlocks;
import net.practice.mod.command.ReturnHomeCommand;
import net.practice.mod.command.SetHomeCommand;
import net.practice.mod.entity.ModEntities;
import net.practice.mod.entity.custom.FurryEntity;
import net.practice.mod.event.ModPlayerEventCopyFrom;
import net.practice.mod.event.UseItemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PracticeMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "practice-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger("practice-mod");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FabricDefaultAttributeRegistry.register(ModEntities.FURRY, FurryEntity.setAttributes());

		registerEvents();
		registerCommands();
	}

	public static void registerCommands(){
		CommandRegistrationCallback.EVENT.register((data,res,red) -> SetHomeCommand.register(data));
		CommandRegistrationCallback.EVENT.register((data,res,red) -> ReturnHomeCommand.register(data));
	}

	public static void registerEvents(){

		UseItemCallback.EVENT.register(new UseItemHandler());

		ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());

	}
}