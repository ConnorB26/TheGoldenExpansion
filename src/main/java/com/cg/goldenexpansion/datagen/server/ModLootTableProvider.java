package com.cg.goldenexpansion.datagen.server;

import com.cg.goldenexpansion.datagen.BaseLootTableProvider;
import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ModLootTableProvider extends BaseLootTableProvider
{
	public ModLootTableProvider(DataGenerator generator)
	{
		super(generator);
	}

	@Override
	protected void addTables()
	{
		// Drop self
		dropSelf(BlockInit.GOLDEN_PUMPKIN.get());
		dropSelf(BlockInit.GOLDEN_CARVED_PUMPKIN.get());
		dropSelf(BlockInit.GOLDEN_JACK_O_LANTERN.get());
		dropSelf(BlockInit.GOLDEN_SAPLING.get());
		dropSelf(BlockInit.GOLDEN_LOG.get());
		dropSelf(BlockInit.GOLDEN_WOOD.get());
		dropSelf(BlockInit.STRIPPED_GOLDEN_LOG.get());
		dropSelf(BlockInit.STRIPPED_GOLDEN_WOOD.get());
		dropSelf(BlockInit.GOLDEN_PLANKS.get());
		dropSelf(BlockInit.GOLDEN_STAIRS.get());
		dropSelf(BlockInit.GOLDEN_SLAB.get());
		dropSelf(BlockInit.GOLDEN_FENCE.get());
		dropSelf(BlockInit.GOLDEN_FENCE_GATE.get());
		dropSelf(BlockInit.GOLDEN_SIGN.get());
		dropSelf(BlockInit.GOLDEN_WALL_SIGN.get());
		dropSelf(BlockInit.GOLDEN_WOODEN_DOOR.get());
		dropSelf(BlockInit.GOLDEN_WOODEN_TRAPDOOR.get());
		dropSelf(BlockInit.GOLDEN_WOODEN_PRESSURE_PLATE.get());
		dropSelf(BlockInit.GOLDEN_BUTTON.get());
		dropSelf(BlockInit.GOLDEN_CRAFTING_TABLE.get());
		
		// Silk touch
		silkTouch(BlockInit.GOLDEN_MELON.get(), Items.GLISTERING_MELON_SLICE, 3, 7);
	}

	protected void silkTouch(Block block, Item silk, int min, int max)
	{
		add(block, createSilkTouchTable(ForgeRegistries.BLOCKS.getKey(block).getPath(), block, silk, min, max));
	}

	protected void dropSelf(Block block)
	{
		add(block, createSimpleTable(ForgeRegistries.BLOCKS.getKey(block).getPath(), block));
	}
}