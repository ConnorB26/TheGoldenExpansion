package com.cg.goldenexpansion.world.feature.tree;

import com.cg.goldenexpansion.world.feature.ModConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class GoldenTreeGrower extends AbstractTreeGrower
{
	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource source, boolean b)
	{
		return ModConfiguredFeatures.GOLDEN_TREE;
	}
}
