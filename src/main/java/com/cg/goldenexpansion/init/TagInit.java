package com.cg.goldenexpansion.init;

import com.cg.goldenexpansion.GoldenExpansion;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagInit
{
	public static final class Blocks
	{
		public static final TagKey<Block> GOLDEN_LOGS = mod("golden_logs");
		
		private static TagKey<Block> mod(String path)
		{
			return BlockTags.create(new ResourceLocation(GoldenExpansion.MOD_ID, path));
		}
	}
	
	public static final class Items
	{
		public static final TagKey<Item> GOLDEN_LOGS = mod("golden_logs");
		
		private static TagKey<Item> mod(String path)
		{
			return ItemTags.create(new ResourceLocation(GoldenExpansion.MOD_ID, path));
		}
	}
}
