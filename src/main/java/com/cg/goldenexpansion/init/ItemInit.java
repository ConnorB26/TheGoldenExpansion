package com.cg.goldenexpansion.init;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.item.FlintAndGold;
import com.google.common.base.Supplier;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
	// Setup deferred registers
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoldenExpansion.MOD_ID);
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
	
	// Non plantable non-foods
	public static final RegistryObject<Item> FLINT_AND_GOLD = register("flint_and_gold", () -> new FlintAndGold(goldenTab().stacksTo(1).defaultDurability(10)));
	public static final RegistryObject<Item> GOLDEN_WHEAT = register("golden_wheat", () -> new Item(goldenTab()));
	public static final RegistryObject<Item> GOLDEN_STICK = register("golden_stick", () -> new Item(goldenTab()));
	public static final RegistryObject<Item> GOLDEN_SIGN = register("golden_sign", () -> new SignItem(goldenTab().stacksTo(16), BlockInit.GOLDEN_SIGN.get(), BlockInit.GOLDEN_WALL_SIGN.get()));
	
	// Non plantable foods
	public static final RegistryObject<Item> GOLDEN_BREAD = register("golden_bread", () -> new Item(goldenFood(Items.BREAD)));
	public static final RegistryObject<Item> GOLDEN_BAKED_POTATO = register("golden_baked_potato", () -> new Item(goldenFood(Items.BAKED_POTATO)));
	public static final RegistryObject<Item> GOLDEN_BEETROOT = register("golden_beetroot", () -> new Item(goldenFood(Items.BEETROOT)));
	public static final RegistryObject<Item> GOLDEN_BEETROOT_SOUP = register("golden_beetroot_soup", () -> new Item(goldenFood(Items.BEETROOT_SOUP)));
	public static final RegistryObject<Item> GOLDEN_PUMPKIN_PIE = register("golden_pumpkin_pie", () -> new Item(goldenFood(Items.PUMPKIN_PIE)));
	
	// Plantable foods
	public static final RegistryObject<Item> GOLDEN_CARROT = VANILLA_ITEMS.register("golden_carrot", () -> new ItemNameBlockItem(BlockInit.GOLDEN_CARROTS.get(), goldenFood(Items.CARROT)));
	public static final RegistryObject<Item> GOLDEN_POTATO = register("golden_potato", () -> new ItemNameBlockItem(BlockInit.GOLDEN_POTATOES.get(), goldenFood(Items.POTATO)));
	public static final RegistryObject<Item> BLUEBERRIES = register("blueberries", () -> new ItemNameBlockItem(BlockInit.BLUEBERRY_BUSH.get(), goldenTab().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build())));
	public static final RegistryObject<Item> GOLDEN_BLUEBERRIES = register("golden_blueberries", () -> new ItemNameBlockItem(BlockInit.GOLDEN_BLUEBERRY_BUSH.get(), goldenFood(BLUEBERRIES.get())));
	public static final RegistryObject<Item> GOLDEN_SWEET_BERRIES = register("golden_sweet_berries", () -> new ItemNameBlockItem(BlockInit.GOLDEN_SWEET_BERRY_BUSH.get(), goldenFood(Items.SWEET_BERRIES)));
	
	// Plantable non-foods
	public static final RegistryObject<Item> GOLDEN_WHEAT_SEEDS = register("golden_wheat_seeds", () -> new ItemNameBlockItem(BlockInit.GOLDEN_WHEAT.get(), goldenTab()));
	public static final RegistryObject<Item> GOLDEN_BEETROOT_SEEDS = register("golden_beetroot_seeds", () -> new ItemNameBlockItem(BlockInit.GOLDEN_BEETROOTS.get(), goldenTab()));
	public static final RegistryObject<Item> GOLDEN_MELON_SEEDS = register("golden_melon_seeds", () -> new ItemNameBlockItem(BlockInit.GOLDEN_MELON_STEM.get(), goldenTab()));
	public static final RegistryObject<Item> GOLDEN_PUMPKIN_SEEDS = register("golden_pumpkin_seeds", () -> new ItemNameBlockItem(BlockInit.GOLDEN_PUMPKIN_STEM.get(), goldenTab()));
	
	// Helper functions
	@SuppressWarnings("deprecation")
	private static Properties goldenFood(Item originalItem)
	{
		return goldenTab().food(new FoodProperties.Builder()
				.nutrition(originalItem.getFoodProperties().getNutrition() * 2)
				.saturationMod(originalItem.getFoodProperties().getSaturationModifier() * 2).build());
	}
	
	private static Properties goldenTab()
	{
		return new Item.Properties().tab(GoldenExpansion.GOLDEN_TAB);
	}
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item)
	{
		return ITEMS.register(name, item);
	}
}
