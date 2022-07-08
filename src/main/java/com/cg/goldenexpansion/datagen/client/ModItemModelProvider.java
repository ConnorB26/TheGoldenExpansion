package com.cg.goldenexpansion.datagen.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper helper)
	{
		super(generator, GoldenExpansion.MOD_ID, helper);
	}

	@Override
	protected void registerModels()
	{
		// Items
		oneLayerItem(ItemInit.FLINT_AND_GOLD.get());
		oneLayerItem(ItemInit.GOLDEN_WHEAT.get());
		oneLayerItem(ItemInit.GOLDEN_STICK.get());
		oneLayerItem(ItemInit.GOLDEN_BREAD.get());
		oneLayerItem(ItemInit.GOLDEN_BAKED_POTATO.get());
		oneLayerItem(ItemInit.GOLDEN_BEETROOT.get());
		oneLayerItem(ItemInit.GOLDEN_BEETROOT_SOUP.get());
		oneLayerItem(ItemInit.GOLDEN_PUMPKIN_PIE.get());
		oneLayerItem(ItemInit.BLUEBERRIES.get());
		oneLayerItem(ItemInit.GOLDEN_BLUEBERRIES.get());
		oneLayerItem(ItemInit.GOLDEN_SWEET_BERRIES.get());
		oneLayerItem(ItemInit.GOLDEN_WHEAT_SEEDS.get());
		oneLayerItem(ItemInit.GOLDEN_BEETROOT_SEEDS.get());
		oneLayerItem(ItemInit.GOLDEN_MELON_SEEDS.get());
		oneLayerItem(ItemInit.GOLDEN_PUMPKIN_SEEDS.get());
		
		// Blocks
		simpleBlockItem(BlockInit.GOLDEN_WHEAT.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_POTATOES.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_CARROTS.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_BEETROOTS.get().asItem());
		simpleBlockItem(BlockInit.BLUEBERRY_BUSH.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_BLUEBERRY_BUSH.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_SWEET_BERRY_BUSH.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_MELON.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_MELON_STEM.get().asItem());
		simpleBlockItem(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_PUMPKIN.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_PUMPKIN_STEM.get().asItem());
		simpleBlockItem(BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_SAPLING.get().asItem());
		simpleBlockItem(BlockInit.POTTED_GOLDEN_SAPLING.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_LEAVES.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_LOG.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_WOOD.get().asItem());
		simpleBlockItem(BlockInit.STRIPPED_GOLDEN_LOG.get().asItem());
		simpleBlockItem(BlockInit.STRIPPED_GOLDEN_WOOD.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_PLANKS.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_STAIRS.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_SLAB.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_TRAPDOOR.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_PRESSURE_PLATE.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_FENCE_GATE.get().asItem());
		
		oneLayerItem(BlockInit.GOLDEN_SIGN.get().asItem());
		oneLayerItem(BlockInit.GOLDEN_DOOR.get().asItem());
		simpleBlockItem(BlockInit.GOLDEN_BUTTON.get().asItem(), "_inventory");
		simpleBlockItem(BlockInit.GOLDEN_FENCE.get().asItem(), "_inventory");
		
	}

	// Helper functions
	protected ResourceLocation itemRL(Item item)
	{
		return ForgeRegistries.ITEMS.getKey(item);
	}
	
	protected void simpleBlockItem(Item item)
	{
		simpleBlockItem(item, "");
	}
	
	protected void simpleBlockItem(Item item, String suffix)
	{
		getBuilder(itemRL(item).toString()).parent(getExistingFile(modLoc("block/" + itemRL(item).getPath() + suffix)));
	}
	
	protected void oneLayerItem(Item item)
	{
		oneLayerItem(item, itemRL(item));
	}

	protected void oneLayerItem(Item item, ResourceLocation texture)
	{
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures"))
		{
			getBuilder(itemRL(item).getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", itemTexture);
		}
		else
		{
			System.out.println("Texture for " + itemRL(item).toString() + " not present at " + itemTexture.toString());
		}
	}
}