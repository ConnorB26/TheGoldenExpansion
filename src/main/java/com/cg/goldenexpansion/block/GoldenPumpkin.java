package com.cg.goldenexpansion.block;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class GoldenPumpkin extends StemGrownBlock
{
	public GoldenPumpkin(Properties properties)
	{
		super(properties);
	}

	public StemBlock getStem()
	{
		return (StemBlock)BlockInit.GOLDEN_PUMPKIN_STEM.get();
	}
	
	public AttachedStemBlock getAttachedStem()
	{
		return (AttachedStemBlock)BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get();
	}
}
