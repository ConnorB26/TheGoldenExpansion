package com.cg.goldenexpansion.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GoldenExpansion.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModEventBusSubscriber
{
	@SuppressWarnings("removal")
	@SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
	{
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_DOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_TRAPDOOR.get(), RenderType.translucent());
		
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_LEAVES.get(), RenderType.cutoutMipped());
		
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_POTATOES.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_CARROTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_BEETROOTS.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_WHEAT.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BLUEBERRY_BUSH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_BLUEBERRY_BUSH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_SWEET_BERRY_BUSH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_MELON_STEM.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_PUMPKIN_STEM.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), RenderType.cutout());
    }
}
