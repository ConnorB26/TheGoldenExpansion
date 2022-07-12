package com.cg.goldenexpansion.datagen.server;

import java.util.function.Consumer;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.cg.goldenexpansion.init.ItemInit;
import com.cg.goldenexpansion.init.TagInit;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeProvider extends RecipeProvider
{
	public ModRecipeProvider(DataGenerator generator)
	{
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
	{
		Block planks = BlockInit.GOLDEN_PLANKS.get();
		String goldenPlanksPath = blockPath(planks);
		InventoryChangeTrigger.TriggerInstance hasGoldenPlanks = has(planks);
		String hasGoldenPlanksString = "has_" + goldenPlanksPath;
		
		//Item stick = ItemInit.GOLDEN_STICK.get();
		Item stick = Items.STICK;
		String stickPath = itemPath(stick);
		InventoryChangeTrigger.TriggerInstance hasGoldenStick = has(stick);
		String hasGoldenStickString = "has_" + stickPath;
		
		// Shaped Recipes
		ShapedRecipeBuilder.shaped(ItemInit.GOLDEN_BREAD.get())
			.define('x', ItemInit.GOLDEN_WHEAT.get())
			.pattern("xxx")
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_WHEAT.get()), has(ItemInit.GOLDEN_WHEAT.get()))
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_MELON.get())
			.define('x', Items.GLISTERING_MELON_SLICE)
			.pattern("xxx").pattern("xxx").pattern("xxx")
			.unlockedBy("has_" + itemPath(Items.GLISTERING_MELON_SLICE), has(Items.GLISTERING_MELON_SLICE))
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_WOOD.get(), 3)
			.define('x', BlockInit.GOLDEN_LOG.get())
			.pattern("xx").pattern("xx")
			.unlockedBy("has_" + blockPath(BlockInit.GOLDEN_LOG.get()), has(BlockInit.GOLDEN_LOG.get()))
			.group("bark")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.STRIPPED_GOLDEN_WOOD.get(), 3)
			.define('x', BlockInit.STRIPPED_GOLDEN_LOG.get())
			.pattern("xx").pattern("xx")
			.unlockedBy("has_" + blockPath(BlockInit.STRIPPED_GOLDEN_LOG.get()), has(BlockInit.STRIPPED_GOLDEN_LOG.get()))
			.group("bark")
			.save(consumer);
		/*ShapedRecipeBuilder.shaped(ItemInit.GOLDEN_STICK.get(), 4)
			.define('x', planks)
			.pattern("x").pattern("x")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.save(consumer);*/
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_STAIRS.get(), 4)
			.define('x', planks)
			.pattern("x  ").pattern("xx ").pattern("xxx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_stairs")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_SLAB.get(), 6)
			.define('x', planks)
			.pattern("xxx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_slab")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_DOOR.get(), 3)
			.define('x', planks)
			.pattern("xx").pattern("xx").pattern("xx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_door")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_TRAPDOOR.get(), 2)
			.define('x', planks)
			.pattern("xxx").pattern("xxx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_trapdoor")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_PRESSURE_PLATE.get())
			.define('x', planks)
			.pattern("xx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_pressure_plate")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_CRAFTING_TABLE.get())
			.define('x', planks)
			.pattern("xx").pattern("xx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_SIGN.get(), 3)
			.define('x', planks).define('s', stick)
			.pattern("xxx").pattern("xxx").pattern(" s ")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks).unlockedBy(hasGoldenStickString, hasGoldenStick)
			.group("wooden_sign")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_FENCE.get(), 3)
			.define('x', planks).define('s', stick)
			.pattern("xsx").pattern("xsx")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks).unlockedBy(hasGoldenStickString, hasGoldenStick)
			.group("wooden_fence")
			.save(consumer);
		ShapedRecipeBuilder.shaped(BlockInit.GOLDEN_FENCE_GATE.get())
			.define('x', planks).define('s', stick)
			.pattern("sxs").pattern("sxs")
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks).unlockedBy(hasGoldenStickString, hasGoldenStick)
			.save(consumer);
		
		// Golden upgrades (too OP to craft - found only?)
		goldUpgrade(Items.BEETROOT_SEEDS, ItemInit.GOLDEN_BEETROOT_SEEDS.get(), consumer);
		goldUpgrade(Items.WHEAT_SEEDS, ItemInit.GOLDEN_WHEAT_SEEDS.get(), consumer);
		goldUpgrade(Items.POTATO, ItemInit.GOLDEN_POTATO.get(), consumer);
		goldUpgrade(Items.SWEET_BERRIES, ItemInit.GOLDEN_SWEET_BERRIES.get(), consumer);
		goldUpgrade(ItemInit.BLUEBERRIES.get(), ItemInit.GOLDEN_BLUEBERRIES.get(), consumer);
		goldUpgrade(Items.MELON_SEEDS, ItemInit.GOLDEN_MELON_SEEDS.get(), consumer);
		goldUpgrade(Items.PUMPKIN_SEEDS, ItemInit.GOLDEN_PUMPKIN_SEEDS.get(), consumer);
		goldUpgrade(Items.CARROT, ItemInit.GOLDEN_CARROT.get(), consumer); // have to save to original mc location?
		
		// Shapeless Recipes
		ShapelessRecipeBuilder.shapeless(planks, 4)
			.requires(TagInit.Items.GOLDEN_LOGS)
			.unlockedBy("has_golden_logs", has(TagInit.Items.GOLDEN_LOGS))
			.group("planks")
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(BlockInit.GOLDEN_BUTTON.get())
			.requires(planks)
			.unlockedBy(hasGoldenPlanksString, hasGoldenPlanks)
			.group("wooden_button")
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemInit.FLINT_AND_GOLD.get())
			.requires(Items.GOLD_INGOT).requires(Items.FLINT)
			.unlockedBy("has_" + itemPath(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).unlockedBy("has_" + itemPath(Items.FLINT), has(Items.FLINT))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemInit.GOLDEN_PUMPKIN_PIE.get())
			.requires(Items.EGG).requires(Items.SUGAR).requires(BlockInit.GOLDEN_PUMPKIN.get())
			.unlockedBy("has_" + itemPath(Items.EGG), has(Items.EGG)).unlockedBy("has_" + itemPath(Items.SUGAR), has(Items.SUGAR))
			.unlockedBy("has_" + blockPath(BlockInit.GOLDEN_PUMPKIN.get()), has(BlockInit.GOLDEN_PUMPKIN.get()))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemInit.GOLDEN_MELON_SEEDS.get())
			.requires(Items.GLISTERING_MELON_SLICE)
			.unlockedBy("has_" + itemPath(Items.GLISTERING_MELON_SLICE), has(Items.GLISTERING_MELON_SLICE))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemInit.GOLDEN_PUMPKIN_SEEDS.get(), 4)
			.requires(BlockInit.GOLDEN_PUMPKIN.get())
			.unlockedBy("has_" + blockPath(BlockInit.GOLDEN_PUMPKIN.get()), has(BlockInit.GOLDEN_PUMPKIN.get()))
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(Items.YELLOW_DYE)
			.requires(ItemInit.GOLDEN_BEETROOT.get())
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_BEETROOT.get()), has(ItemInit.GOLDEN_BEETROOT.get()))
			.group("yellow_dye")
			.save(consumer);
		ShapelessRecipeBuilder.shapeless(ItemInit.GOLDEN_BEETROOT_SOUP.get())
			.requires(ItemInit.GOLDEN_BEETROOT.get(), 6).requires(Items.BOWL)
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_BEETROOT.get()), has(ItemInit.GOLDEN_BEETROOT.get())).unlockedBy("has_" + itemPath(Items.BOWL), has(Items.BOWL))
			.save(consumer);
		
		// Cooking Recipes
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.GOLDEN_POTATO.get()), ItemInit.GOLDEN_BAKED_POTATO.get(), 0.35f, 200)
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_POTATO.get()), has(ItemInit.GOLDEN_POTATO.get()))
			.save(consumer, modLoc(itemPath(ItemInit.GOLDEN_BAKED_POTATO.get())));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemInit.GOLDEN_POTATO.get()), ItemInit.GOLDEN_BAKED_POTATO.get(), 0.35f, 100)
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_POTATO.get()), has(ItemInit.GOLDEN_POTATO.get()))
			.save(consumer, modLoc(itemPath(ItemInit.GOLDEN_BAKED_POTATO.get()) + "_smoker"));
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemInit.GOLDEN_POTATO.get()), ItemInit.GOLDEN_BAKED_POTATO.get(), 0.35f, 600)
			.unlockedBy("has_" + itemPath(ItemInit.GOLDEN_POTATO.get()), has(ItemInit.GOLDEN_POTATO.get()))
			.save(consumer, modLoc(itemPath(ItemInit.GOLDEN_BAKED_POTATO.get()) + "_campfire"));
	}
	
	private void goldUpgrade(Item oldItem, Item newItem, Consumer<FinishedRecipe> consumer)
	{
		ShapedRecipeBuilder.shaped(newItem)
			.define('g', Items.GOLD_INGOT).define('x', oldItem)
			.pattern("ggg").pattern("gxg").pattern("ggg")
			.unlockedBy("has_" + itemPath(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).unlockedBy("has_" + itemPath(oldItem), has(oldItem))
			.save(consumer, modLoc(itemPath(newItem) + "_upgrade"));
	}
	
	private ResourceLocation modLoc(String path)
	{
		return new ResourceLocation(GoldenExpansion.MOD_ID, path);
	}
	
	private String itemPath(Item item)
	{
		return ForgeRegistries.ITEMS.getKey(item).getPath();
	}
	
	private String blockPath(Block block)
	{
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}
}