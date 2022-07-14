package com.cg.goldenexpansion.world.feature;

import com.cg.goldenexpansion.GoldenExpansion;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unchecked")
public class ModPlacedFeatures
{
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, GoldenExpansion.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> GOLDEN_PLACED = PLACED_FEATURES.register("golden_placed",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.GOLDEN_SPAWN, VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,  0.1f, 2))));
	
	public static final RegistryObject<PlacedFeature> PATCH_GOLDEN_PUMPKIN = PLACED_FEATURES.register("patch_golden_pumpkin",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.PATCH_GOLDEN_PUMPKIN, List.of(RarityFilter.onAverageOnceEvery(300), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> PATCH_GOLDEN_MELON = PLACED_FEATURES.register("patch_golden_melon",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.PATCH_GOLDEN_MELON, List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> PATCH_BLUEBERRY = PLACED_FEATURES.register("patch_blueberry",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.PATCH_BLUEBERRY_BUSH, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> PATCH_GOLDEN_BLUEBERRY = PLACED_FEATURES.register("patch_golden_blueberry",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.PATCH_GOLDEN_BLUEBERRY_BUSH, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
	
	public static final RegistryObject<PlacedFeature> PATCH_GOLDEN_SWEET_BERRY = PLACED_FEATURES.register("patch_golden_sweet_berry",
			() -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
			ModConfiguredFeatures.PATCH_GOLDEN_SWEET_BERRY_BUSH, List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
}
