package com.cg.goldenexpansion.block;

import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class StrippableBlock extends RotatedPillarBlock
{
	public StrippableBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate)
	{
	    if(toolAction.equals(ToolActions.AXE_STRIP))
	    {
    		if(state.is(BlockInit.GOLDEN_LOG.get()))
    		{
    			return BlockInit.STRIPPED_GOLDEN_LOG.get().withPropertiesOf(state);
    		}
    		else if(state.is(BlockInit.GOLDEN_WOOD.get()))
    		{
    			return BlockInit.STRIPPED_GOLDEN_WOOD.get().withPropertiesOf(state);
    		}
	    }

	    return super.getToolModifiedState(state, context, toolAction, simulate);
	}
}
