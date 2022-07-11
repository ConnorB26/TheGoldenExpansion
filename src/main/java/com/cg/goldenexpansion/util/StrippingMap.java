package com.cg.goldenexpansion.util;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class StrippingMap
{
	public static void createStrippable(Block input, Block output)
	{
		//AxeItem.STRIPPABLES.put(input, output); // = Maps.newHashMap(AxeItem.STRIPPABLES);
	}
	
	public static void registerStrippables()
	{
		createStrippable(BlockInit.GOLDEN_LOG.get(), BlockInit.STRIPPED_GOLDEN_LOG.get());
	}
}
