package com.cg.goldenexpansion.block.plants.crops;

import com.cg.goldenexpansion.block.plants.GoldenPlantData;
import com.cg.goldenexpansion.init.ItemInit;
import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GoldenBeetrootBlock extends BeetrootBlock
{	
	public GoldenBeetrootBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	protected ItemLike getBaseSeedId()
	{
		return ItemInit.GOLDEN_BEETROOT_SEEDS.get();
    }
	
	@Override
	public IntegerProperty getAgeProperty()
	{
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(AGE);
    }
    
    @SuppressWarnings("deprecation")
    @Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource)
    {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos, 0) >= 9 && randomSource.nextInt(3) != 0)
        {
           int i = this.getAge(state);
           if (i < this.getMaxAge())
           {
              float f = getGrowthSpeed(this, level, pos) * (level.getBiome(pos).is(TagInit.Biomes.IS_GOLDEN) ? GoldenPlantData.goldenBiomeGrowthRateMultiplier : GoldenPlantData.normalGrowthRateMultiplier);
              if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, randomSource.nextInt((int)(25.0F / f) + 1) == 0))
              {
                 level.setBlock(pos, this.getStateForAge(i + 1), 2);
                 net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
              }
           }
        }
    }
}
