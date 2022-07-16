package com.cg.goldenexpansion.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class GoldenShears extends ShearsItem
{
	public GoldenShears(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public float getDestroySpeed(ItemStack p_43084_, BlockState p_43085_)
	{
	      if (!p_43085_.is(Blocks.COBWEB) && !p_43085_.is(BlockTags.LEAVES))
	      {
	         if (p_43085_.is(BlockTags.WOOL))
	         {
	            return 2 * 5.0F;
	         }
	         else
	         {
	            return !p_43085_.is(Blocks.VINE) && !p_43085_.is(Blocks.GLOW_LICHEN) ? 2 * super.getDestroySpeed(p_43084_, p_43085_) : 2 * 2.0F;
	         }
	      }
	      else
	      {
	         return 2 * 15.0F;
	      }
	   }
}
