package com.cg.goldenexpansion.item;

import com.cg.goldenexpansion.block.GoldenPortalBlock;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.world.dimension.ModDimensions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class FlintAndGold extends FlintAndSteelItem
{
	public FlintAndGold(Properties properties)
	{
		super(properties);
	}
	
	@Override
    public InteractionResult useOn(UseOnContext context)
	{
		if(context.getPlayer() != null);
		{
            if(context.getPlayer().level.dimension() == ModDimensions.GOLDEN_DIM_KEY || context.getPlayer().level.dimension() == Level.OVERWORLD)
            {
                for(Direction direction : Direction.Plane.VERTICAL)
                {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((GoldenPortalBlock) BlockInit.GOLDEN_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos))
                    {
                        context.getLevel().playSound(context.getPlayer(), framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
		
		return super.useOn(context);
    }
}
