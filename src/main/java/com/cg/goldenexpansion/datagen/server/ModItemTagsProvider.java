package com.cg.goldenexpansion.datagen.server;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider
{
	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper)
	{
		super(generator, blocks, GoldenExpansion.MOD_ID, helper);
	}
	
	@Override
	protected void addTags()
	{
		// Item tags
		tag(ItemTags.PLANKS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.LOGS_THAT_BURN).addTag(TagInit.Items.GOLDEN_LOGS);
		tag(ItemTags.SIGNS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.SAPLINGS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_BUTTONS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_DOORS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_FENCES).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_SLABS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_STAIRS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.WOODEN_TRAPDOORS).add(BlockInit.GOLDEN_PLANKS.get().asItem());
		tag(ItemTags.LEAVES).add(BlockInit.GOLDEN_LEAVES.get().asItem());
		
		// Golden log tag
		tag(TagInit.Items.GOLDEN_LOGS).add(BlockInit.GOLDEN_LOG.get().asItem());
		tag(TagInit.Items.GOLDEN_LOGS).add(BlockInit.GOLDEN_WOOD.get().asItem());
		tag(TagInit.Items.GOLDEN_LOGS).add(BlockInit.STRIPPED_GOLDEN_LOG.get().asItem());
		tag(TagInit.Items.GOLDEN_LOGS).add(BlockInit.STRIPPED_GOLDEN_WOOD.get().asItem());
	}
}