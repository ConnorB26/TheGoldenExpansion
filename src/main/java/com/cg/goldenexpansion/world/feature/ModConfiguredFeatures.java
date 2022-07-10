package com.cg.goldenexpansion.world.feature;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures
{
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GOLDEN_TREE =
            FeatureUtils.register("golden", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockInit.GOLDEN_LOG.get()),
                    new StraightTrunkPlacer(4, 5, 3),
                    BlockStateProvider.simple(BlockInit.GOLDEN_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
}
