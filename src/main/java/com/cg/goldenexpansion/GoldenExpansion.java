package com.cg.goldenexpansion;

import com.cg.goldenexpansion.init.BlockEntitiesInit;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GoldenExpansion.MOD_ID)
public class GoldenExpansion
{
	public static final String MOD_ID = "goldenexpansion";
	
	public static final CreativeModeTab GOLDEN_TAB = new CreativeModeTab("goldenexpansion")
	{
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon()
		{
			return new ItemStack(Items.GOLD_INGOT);
		}
	};
	
	public GoldenExpansion()
	{
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(modEventBus);
		ItemInit.VANILLA_ITEMS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		BlockEntitiesInit.BLOCK_ENTITIES.register(modEventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
