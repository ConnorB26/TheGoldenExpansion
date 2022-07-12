package com.cg.goldenexpansion.datagen.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider
{
	public ModEnUsProvider(DataGenerator gen)
	{
		super(gen, GoldenExpansion.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations()
	{
		// Item Groups
		add("itemGroup.goldenexpansion", "The Golden Expansion");
		
		// Items
		add(ItemInit.FLINT_AND_GOLD.get(), "Flint and Gold");
		add(ItemInit.GOLDEN_WHEAT.get(), "Golden Wheat");
		//add(ItemInit.GOLDEN_STICK.get(), "Golden Stick");
		add(ItemInit.GOLDEN_BREAD.get(), "Golden Bread");
		add(ItemInit.GOLDEN_POTATO.get(), "Golden Potato");
		add(ItemInit.GOLDEN_BAKED_POTATO.get(), "Golden Baked Potato");
		add(ItemInit.GOLDEN_BEETROOT.get(), "Golden Beetroot");
		add(ItemInit.GOLDEN_BEETROOT_SOUP.get(), "Golden Beetroot Soup");
		add(ItemInit.GOLDEN_PUMPKIN_PIE.get(), "Golden Pumpkin Pie");
		add(ItemInit.BLUEBERRIES.get(), "Blueberries");
		add(ItemInit.GOLDEN_BLUEBERRIES.get(), "Golden Blueberries");
		add(ItemInit.GOLDEN_SWEET_BERRIES.get(), "Golden Sweet Berries");
		add(ItemInit.GOLDEN_WHEAT_SEEDS.get(), "Golden Wheat Seeds");
		add(ItemInit.GOLDEN_BEETROOT_SEEDS.get(), "Golden Beetroot Seeds");
		add(ItemInit.GOLDEN_MELON_SEEDS.get(), "Golden Melon Seeds");
		add(ItemInit.GOLDEN_PUMPKIN_SEEDS.get(), "Golden Pumpkin Seeds");
		
		// Blocks
		add(BlockInit.GOLDEN_WHEAT.get(), "Golden Wheat Plant");
		add(BlockInit.GOLDEN_POTATOES.get(), "Golden Potato Plant");
		add(BlockInit.GOLDEN_CARROTS.get(), "Golden Carrot Plant");
		add(BlockInit.GOLDEN_BEETROOTS.get(), "Golden Beetroot Plant");
		add(BlockInit.BLUEBERRY_BUSH.get(), "Blueberry Bush");
		add(BlockInit.GOLDEN_BLUEBERRY_BUSH.get(), "Golden Blueberry Bush");
		add(BlockInit.GOLDEN_SWEET_BERRY_BUSH.get(), "Golden Sweet Berry Bush");
		add(BlockInit.GOLDEN_MELON.get(), "Golden Melon");
		add(BlockInit.GOLDEN_MELON_STEM.get(), "Golden Melon Stem");
		add(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get(), "Golden Melon Stem");
		add(BlockInit.GOLDEN_PUMPKIN.get(), "Golden Pumpkin");
		add(BlockInit.GOLDEN_PUMPKIN_STEM.get(), "Golden Pupmkin Stem");
		add(BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), "Golden Pupmkin Stem");
		add(BlockInit.GOLDEN_SAPLING.get(), "Golden Sapling");
		add(BlockInit.POTTED_GOLDEN_SAPLING.get(), "Potted Golden Sapling");
		add(BlockInit.GOLDEN_LEAVES.get(), "Golden Leaves");
		add(BlockInit.GOLDEN_LOG.get(), "Golden Log");
		add(BlockInit.GOLDEN_WOOD.get(), "Golden Wood");
		add(BlockInit.STRIPPED_GOLDEN_LOG.get(), "Stripped Golden Log");
		add(BlockInit.STRIPPED_GOLDEN_WOOD.get(), "Stripped Golden Wood");
		add(BlockInit.GOLDEN_PLANKS.get(), "Golden Planks");
		add(BlockInit.GOLDEN_STAIRS.get(), "Golden Stairs");
		add(BlockInit.GOLDEN_SLAB.get(), "Golden Slab");
		add(BlockInit.GOLDEN_FENCE.get(), "Golden Fence");
		add(BlockInit.GOLDEN_FENCE_GATE.get(), "Golden Fence Gate");
		add(BlockInit.GOLDEN_DOOR.get(), "Golden Door");
		add(BlockInit.GOLDEN_TRAPDOOR.get(), "Golden Trapdoor");
		add(BlockInit.GOLDEN_PRESSURE_PLATE.get(), "Golden Pressure Plate");
		add(BlockInit.GOLDEN_BUTTON.get(), "Golden Button");
		add(BlockInit.GOLDEN_SIGN.get(), "Golden Sign");
		add(BlockInit.GOLDEN_CRAFTING_TABLE.get(), "Golden Crafting Table");
	}
}