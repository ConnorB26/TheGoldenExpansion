package com.cg.goldenexpansion.block.crops;

import com.cg.goldenexpansion.init.ItemInit;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GoldenWheatBlock extends CropBlock
{	
	public GoldenWheatBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	protected ItemLike getBaseSeedId()
	{
		return ItemInit.GOLDEN_WHEAT_SEEDS.get();
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
}
