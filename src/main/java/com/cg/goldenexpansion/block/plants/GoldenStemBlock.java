package com.cg.goldenexpansion.block.plants;

import java.util.function.Supplier;

import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenStemBlock extends StemBlock
{
	public GoldenStemBlock(StemGrownBlock p_154728_, Supplier<Item> p_154729_, Properties p_154730_)
	{
		super(p_154728_, p_154729_, p_154730_);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(BlockState p_222538_, ServerLevel p_222539_, BlockPos p_222540_, RandomSource p_222541_) {
	      if (!p_222539_.isAreaLoaded(p_222540_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
	      if (p_222539_.getRawBrightness(p_222540_, 0) >= 9) {
	         float f = CropBlock.getGrowthSpeed(this, p_222539_, p_222540_) * (p_222539_.getBiome(p_222540_).is(TagInit.Biomes.IS_GOLDEN) ? GoldenPlantData.goldenBiomeGrowthRateMultiplier : GoldenPlantData.normalGrowthRateMultiplier);
	         if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222539_, p_222540_, p_222538_, p_222541_.nextInt((int)(25.0F / f) + 1) == 0)) {
	            int i = p_222538_.getValue(AGE);
	            if (i < 7) {
	               p_222539_.setBlock(p_222540_, p_222538_.setValue(AGE, Integer.valueOf(i + 1)), 2);
	            } else {
	               Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(p_222541_);
	               BlockPos blockpos = p_222540_.relative(direction);
	               BlockState blockstate = p_222539_.getBlockState(blockpos.below());
	               Block block = blockstate.getBlock();
	               if (p_222539_.isEmptyBlock(blockpos) && (blockstate.canSustainPlant(p_222539_, blockpos.below(), Direction.UP, this) || block == Blocks.FARMLAND || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.GRASS_BLOCK)) {
	                  p_222539_.setBlockAndUpdate(blockpos, getFruit().defaultBlockState());
	                  p_222539_.setBlockAndUpdate(p_222540_, getFruit().getAttachedStem().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction));
	               }
	            }
	            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222539_, p_222540_, p_222538_);
	         }

	      }
	   }
}
