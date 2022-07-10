package com.cg.goldenexpansion.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.block.entity.ModWoodTypes;
import com.cg.goldenexpansion.init.BlockEntitiesInit;
import com.cg.goldenexpansion.init.BlockInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
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
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GOLDEN_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.POTTED_GOLDEN_SAPLING.get(), RenderType.cutout());
		
		WoodType.register(ModWoodTypes.GOLDEN);
		BlockEntityRenderers.register(BlockEntitiesInit.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }
	
	@SubscribeEvent
    public static void setup(FMLClientSetupEvent event)
	{
		event.enqueueWork(() ->
		{
            Sheets.addWoodType(ModWoodTypes.GOLDEN);
        });
    }
}
