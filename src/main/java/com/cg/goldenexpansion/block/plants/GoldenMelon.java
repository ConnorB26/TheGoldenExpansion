package com.cg.goldenexpansion.block.plants;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class GoldenMelon extends StemGrownBlock
{
	public GoldenMelon(Properties properties)
	{
		super(properties);
	}

	public GoldenStemBlock getStem()
	{
		return (GoldenStemBlock)BlockInit.GOLDEN_MELON_STEM.get();
	}
	
	public AttachedStemBlock getAttachedStem()
	{
		return (AttachedStemBlock)BlockInit.ATTACHED_GOLDEN_MELON_STEM.get();
	}
}
