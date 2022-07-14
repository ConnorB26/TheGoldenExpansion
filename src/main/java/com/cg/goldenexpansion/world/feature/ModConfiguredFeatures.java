package com.cg.goldenexpansion.world.feature;

import java.util.List;

import com.cg.goldenexpansion.block.bushes.BlueberryBushBlock;
import com.cg.goldenexpansion.block.bushes.GoldenBlueberryBushBlock;
import com.cg.goldenexpansion.block.bushes.GoldenSweetBerryBushBlock;
import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModConfiguredFeatures
{
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GOLDEN_TREE =
            FeatureUtils.register("golden", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockInit.GOLDEN_LOG.get()),
                    new StraightTrunkPlacer(4, 5, 3),
                    BlockStateProvider.simple(BlockInit.GOLDEN_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());
	
	public static final Holder<PlacedFeature> GOLDEN_CHECKED = PlacementUtils.register("golden_check", GOLDEN_TREE,
			PlacementUtils.filteredByBlockSurvival(BlockInit.GOLDEN_SAPLING.get()));
	
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> GOLDEN_SPAWN = FeatureUtils.register("golden_spawn", Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(GOLDEN_CHECKED, 0.5f)), GOLDEN_CHECKED));
	
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GOLDEN_PUMPKIN = FeatureUtils.register("patch_golden_pumpkin", Feature.RANDOM_PATCH,
			FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.GOLDEN_PUMPKIN.get())), List.of(Blocks.GRASS_BLOCK)));
	
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GOLDEN_MELON = FeatureUtils.register("patch_golden_melon", Feature.RANDOM_PATCH,
			new RandomPatchConfiguration(64, 7, 3, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.GOLDEN_MELON.get())),
					BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))));
	
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLUEBERRY_BUSH = FeatureUtils.register("patch_blueberry_bush", Feature.RANDOM_PATCH,
			FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.BLUEBERRY_BUSH.get().defaultBlockState()
					.setValue(BlueberryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
	
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GOLDEN_BLUEBERRY_BUSH = FeatureUtils.register("patch_golden_blueberry_bush", Feature.RANDOM_PATCH,
			FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.GOLDEN_BLUEBERRY_BUSH.get().defaultBlockState()
					.setValue(GoldenBlueberryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
	
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GOLDEN_SWEET_BERRY_BUSH = FeatureUtils.register("patch_golden_sweet_berry_bush", Feature.RANDOM_PATCH,
			FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.GOLDEN_SWEET_BERRY_BUSH.get().defaultBlockState()
					.setValue(GoldenSweetBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK)));
}
