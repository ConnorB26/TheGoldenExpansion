package com.cg.goldenexpansion.block.plants;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class GoldenPumpkin extends StemGrownBlock
{
	public GoldenPumpkin(Properties properties)
	{
		super(properties);
	}

	public GoldenStemBlock getStem()
	{
		return (GoldenStemBlock)BlockInit.GOLDEN_PUMPKIN_STEM.get();
	}
	
	public AttachedStemBlock getAttachedStem()
	{
		return (AttachedStemBlock)BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get();
	}
}
