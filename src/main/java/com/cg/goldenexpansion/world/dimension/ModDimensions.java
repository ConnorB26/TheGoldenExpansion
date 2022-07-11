package com.cg.goldenexpansion.world.dimension;

import com.cg.goldenexpansion.GoldenExpansion;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions
{
	public static final ResourceKey<Level> GOLDEN_DIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(GoldenExpansion.MOD_ID, "golden_dim"));
	public static final ResourceKey<DimensionType> GOLDEN_DIM_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, GOLDEN_DIM_KEY.registry());
}
