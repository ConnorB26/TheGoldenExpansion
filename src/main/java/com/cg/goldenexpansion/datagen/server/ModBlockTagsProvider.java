package com.cg.goldenexpansion.datagen.server;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider
{
	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper)
	{
		super(generator, GoldenExpansion.MOD_ID, helper);
	}
	
	@Override
	protected void addTags()
	{
		// Block tags
		tag(BlockTags.PLANKS).add(BlockInit.GOLDEN_PLANKS.get());
		tag(BlockTags.LOGS_THAT_BURN).addTag(TagInit.Blocks.GOLDEN_LOGS);
		tag(BlockTags.SIGNS).add(BlockInit.GOLDEN_SIGN.get());
		tag(BlockTags.SIGNS).add(BlockInit.GOLDEN_WALL_SIGN.get());
		tag(BlockTags.SAPLINGS).add(BlockInit.GOLDEN_SAPLING.get());
		tag(BlockTags.FENCE_GATES).add(BlockInit.GOLDEN_FENCE_GATE.get());
		tag(BlockTags.WOODEN_BUTTONS).add(BlockInit.GOLDEN_BUTTON.get());
		tag(BlockTags.WOODEN_DOORS).add(BlockInit.GOLDEN_WOODEN_DOOR.get());
		tag(BlockTags.WOODEN_FENCES).add(BlockInit.GOLDEN_FENCE.get());
		tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockInit.GOLDEN_WOODEN_PRESSURE_PLATE.get());
		tag(BlockTags.WOODEN_SLABS).add(BlockInit.GOLDEN_SLAB.get());
		tag(BlockTags.WOODEN_STAIRS).add(BlockInit.GOLDEN_STAIRS.get());
		tag(BlockTags.WOODEN_TRAPDOORS).add(BlockInit.GOLDEN_WOODEN_TRAPDOOR.get());
		tag(BlockTags.LEAVES).add(BlockInit.GOLDEN_LEAVES.get());
		tag(BlockTags.FLOWER_POTS).add(BlockInit.POTTED_GOLDEN_SAPLING.get());
		
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_WHEAT.get());
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_BEETROOTS.get());
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_CARROTS.get());
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_POTATOES.get());
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_MELON_STEM.get());
		tag(BlockTags.CROPS).add(BlockInit.GOLDEN_PUMPKIN_STEM.get());
		
		tag(BlockTags.PORTALS).add(BlockInit.GOLDEN_PORTAL.get());
		tag(TagInit.Blocks.GOLDEN_PORTAL_FRAME_BLOCKS).add(Blocks.GOLD_BLOCK);
		
		// Golden logs
		tag(TagInit.Blocks.GOLDEN_LOGS).add(BlockInit.GOLDEN_LOG.get());
		tag(TagInit.Blocks.GOLDEN_LOGS).add(BlockInit.GOLDEN_WOOD.get());
		tag(TagInit.Blocks.GOLDEN_LOGS).add(BlockInit.STRIPPED_GOLDEN_LOG.get());
		tag(TagInit.Blocks.GOLDEN_LOGS).add(BlockInit.STRIPPED_GOLDEN_WOOD.get());
		
		// Mineable
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_MELON.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_PUMPKIN.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_CARVED_PUMPKIN.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_JACK_O_LANTERN.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_LOG.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_WOOD.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.STRIPPED_GOLDEN_LOG.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.STRIPPED_GOLDEN_WOOD.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_PLANKS.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_STAIRS.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_SLAB.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_FENCE.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_FENCE_GATE.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_SIGN.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_WALL_SIGN.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_WOODEN_DOOR.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_WOODEN_TRAPDOOR.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_WOODEN_PRESSURE_PLATE.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_BUTTON.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(BlockInit.GOLDEN_CRAFTING_TABLE.get());
	}
}