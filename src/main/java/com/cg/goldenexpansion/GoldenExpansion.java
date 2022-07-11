package com.cg.goldenexpansion;

import com.cg.goldenexpansion.init.BlockEntitiesInit;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.ItemInit;
import com.cg.goldenexpansion.init.POIsInit;
import com.cg.goldenexpansion.init.ParticlesInit;
import com.cg.goldenexpansion.util.StrippingMap;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
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
		POIsInit.POI.register(modEventBus);
		ParticlesInit.PARTICLE_TYPES.register(modEventBus);
		
		modEventBus.addListener(this::onLoadComplete);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void onLoadComplete(final FMLLoadCompleteEvent event)
	{
		StrippingMap.registerStrippables();
	}
}
