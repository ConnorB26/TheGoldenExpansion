package com.cg.goldenexpansion.datagen;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.datagen.client.ModBlockStateProvider;
import com.cg.goldenexpansion.datagen.client.ModEnUsProvider;
import com.cg.goldenexpansion.datagen.client.ModItemModelProvider;
import com.cg.goldenexpansion.datagen.server.ModBlockTagsProvider;
import com.cg.goldenexpansion.datagen.server.ModItemTagsProvider;
import com.cg.goldenexpansion.datagen.server.ModLootTableProvider;
import com.cg.goldenexpansion.datagen.server.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = GoldenExpansion.MOD_ID, bus = Bus.MOD)
public class DataGeneration
{
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
			// Client Data Generation
			generator.addProvider(true, new ModBlockStateProvider(generator, helper));
			generator.addProvider(true, new ModItemModelProvider(generator, helper));
			generator.addProvider(true, new ModEnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(true, new ModRecipeProvider(generator));
			generator.addProvider(true, blockTags);
			generator.addProvider(true, new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(true, new ModLootTableProvider(generator));
			
		}
	}
}