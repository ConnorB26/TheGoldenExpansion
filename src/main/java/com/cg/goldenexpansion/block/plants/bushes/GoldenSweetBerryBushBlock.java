package com.cg.goldenexpansion.block.plants.bushes;

import com.cg.goldenexpansion.block.plants.GoldenPlantData;
import com.cg.goldenexpansion.init.ItemInit;
import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class GoldenSweetBerryBushBlock extends SweetBerryBushBlock
{
	public GoldenSweetBerryBushBlock(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_)
	{
		return new ItemStack(ItemInit.GOLDEN_SWEET_BERRIES.get());
	}
	
	@Override
	public InteractionResult use(BlockState p_57275_, Level p_57276_, BlockPos p_57277_, Player p_57278_, InteractionHand p_57279_, BlockHitResult p_57280_) {
	      int i = p_57275_.getValue(AGE);
	      boolean flag = i == 3;
	      if (!flag && p_57278_.getItemInHand(p_57279_).is(Items.BONE_MEAL)) {
	         return InteractionResult.PASS;
	      } else if (i > 1) {
	         int j = 1 + p_57276_.random.nextInt(2);
	         popResource(p_57276_, p_57277_, new ItemStack(ItemInit.GOLDEN_SWEET_BERRIES.get(), j + (flag ? 1 : 0)));
	         p_57276_.playSound((Player)null, p_57277_, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + p_57276_.random.nextFloat() * 0.4F);
	         p_57276_.setBlock(p_57277_, p_57275_.setValue(AGE, Integer.valueOf(1)), 2);
	         return InteractionResult.sidedSuccess(p_57276_.isClientSide);
	      } else {
	         return super.use(p_57275_, p_57276_, p_57277_, p_57278_, p_57279_, p_57280_);
	      }
	   }
	
	public IntegerProperty getAgeProperty()
	{
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(AGE);
    }
    
    @Override
    public void randomTick(BlockState p_222563_, ServerLevel p_222564_, BlockPos p_222565_, RandomSource p_222566_)
    {
        int i = p_222563_.getValue(AGE);
        if (i < 3 && p_222564_.getRawBrightness(p_222565_.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(p_222564_, p_222565_, p_222563_, p_222566_
        		.nextInt(p_222564_.getBiome(p_222565_).is(TagInit.Biomes.IS_GOLDEN) ? GoldenPlantData.goldenBiomeRandomIntMax : GoldenPlantData.normalRandomIntMax) == 0))
        {
           BlockState blockstate = p_222563_.setValue(AGE, Integer.valueOf(i + 1));
           p_222564_.setBlock(p_222565_, blockstate, 2);
           p_222564_.gameEvent(GameEvent.BLOCK_CHANGE, p_222565_, GameEvent.Context.of(blockstate));
           net.minecraftforge.common.ForgeHooks.onCropsGrowPost(p_222564_, p_222565_, p_222563_);
        }
     }
}
