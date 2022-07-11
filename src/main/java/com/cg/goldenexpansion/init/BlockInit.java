package com.cg.goldenexpansion.init;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.block.GoldenMelon;
import com.cg.goldenexpansion.block.GoldenPortalBlock;
import com.cg.goldenexpansion.block.GoldenPumpkin;
import com.cg.goldenexpansion.block.StrippableBlock;
import com.cg.goldenexpansion.block.bushes.BlueberryBushBlock;
import com.cg.goldenexpansion.block.bushes.GoldenBlueberryBushBlock;
import com.cg.goldenexpansion.block.bushes.GoldenSweetBerryBushBlock;
import com.cg.goldenexpansion.block.crops.GoldenBeetrootBlock;
import com.cg.goldenexpansion.block.crops.GoldenCarrotBlock;
import com.cg.goldenexpansion.block.crops.GoldenPotatoBlock;
import com.cg.goldenexpansion.block.crops.GoldenWheatBlock;
import com.cg.goldenexpansion.block.entity.ModStandingSignBlock;
import com.cg.goldenexpansion.block.entity.ModWallSignBlock;
import com.cg.goldenexpansion.block.entity.ModWoodTypes;
import com.cg.goldenexpansion.world.feature.tree.GoldenTreeGrower;
import com.google.common.base.Function;
import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit
{
	// Setup deferred registers
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoldenExpansion.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	// Plant blocks
	public static final RegistryObject<Block> GOLDEN_WHEAT = registerBlock("golden_wheat", () -> new GoldenWheatBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
	public static final RegistryObject<Block> GOLDEN_POTATOES = registerBlock("golden_potatoes", () -> new GoldenPotatoBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES)));
	public static final RegistryObject<Block> GOLDEN_CARROTS = registerBlock("golden_carrots", () -> new GoldenCarrotBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
	public static final RegistryObject<Block> GOLDEN_BEETROOTS = registerBlock("golden_beetroots", () -> new GoldenBeetrootBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)));
	
	public static final RegistryObject<Block> BLUEBERRY_BUSH = registerBlock("blueberry_bush", () -> new BlueberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> GOLDEN_BLUEBERRY_BUSH = registerBlock("golden_blueberry_bush", () -> new GoldenBlueberryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> GOLDEN_SWEET_BERRY_BUSH = registerBlock("golden_sweet_berry_bush", () -> new GoldenSweetBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
	
	public static final RegistryObject<Block> GOLDEN_MELON = register("golden_melon", () -> new GoldenMelon(BlockBehaviour.Properties.copy(Blocks.MELON)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_MELON_STEM = registerBlock("golden_melon_stem", () -> new StemBlock((StemGrownBlock)GOLDEN_MELON.get(),
			() -> ItemInit.GOLDEN_MELON_SEEDS.get(), BlockBehaviour.Properties.copy(Blocks.MELON_STEM)));
	public static final RegistryObject<Block> ATTACHED_GOLDEN_MELON_STEM = registerBlock("attached_golden_melon_stem", () -> new AttachedStemBlock((StemGrownBlock)GOLDEN_MELON.get(),
			() -> ItemInit.GOLDEN_MELON_SEEDS.get(), BlockBehaviour.Properties.copy(Blocks.ATTACHED_MELON_STEM)));
	
	public static final RegistryObject<Block> GOLDEN_PUMPKIN = register("golden_pumpkin", () -> new GoldenPumpkin(BlockBehaviour.Properties.copy(Blocks.MELON)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_PUMPKIN_STEM = registerBlock("golden_pumpkin_stem", () -> new StemBlock((StemGrownBlock)GOLDEN_PUMPKIN.get(),
			() -> ItemInit.GOLDEN_PUMPKIN_SEEDS.get(), BlockBehaviour.Properties.copy(Blocks.PUMPKIN_STEM)));
	public static final RegistryObject<Block> ATTACHED_GOLDEN_PUMPKIN_STEM = registerBlock("attached_golden_pumpkin_stem", () -> new AttachedStemBlock((StemGrownBlock)GOLDEN_PUMPKIN.get(),
			() -> ItemInit.GOLDEN_PUMPKIN_SEEDS.get(), BlockBehaviour.Properties.copy(Blocks.ATTACHED_PUMPKIN_STEM)));
	
	public static final RegistryObject<Block> GOLDEN_SAPLING = register("golden_sapling", () -> new SaplingBlock(new GoldenTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), goldenBlockItem());
	public static final RegistryObject<Block> POTTED_GOLDEN_SAPLING = registerBlock("potted_golden_sapling", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), () -> GOLDEN_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	
	// Wood blocks
	public static final RegistryObject<Block> GOLDEN_LEAVES = register("golden_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_LOG = register("golden_log", () -> new StrippableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_WOOD = register("golden_wood", () -> new StrippableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), goldenBlockItem());
	public static final RegistryObject<Block> STRIPPED_GOLDEN_LOG = register("stripped_golden_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), goldenBlockItem());
	public static final RegistryObject<Block> STRIPPED_GOLDEN_WOOD = register("stripped_golden_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_PLANKS = register("golden_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_STAIRS = register("golden_stairs", () -> new StairBlock(() -> GOLDEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_SLAB = register("golden_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_FENCE = register("golden_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_FENCE_GATE = register("golden_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_DOOR = register("golden_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_TRAPDOOR = register("golden_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_PRESSURE_PLATE = register("golden_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_BUTTON = register("golden_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_CRAFTING_TABLE = register("golden_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), goldenBlockItem());
	public static final RegistryObject<Block> GOLDEN_SIGN = registerBlock("golden_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.GOLDEN));
	public static final RegistryObject<Block> GOLDEN_WALL_SIGN = registerBlock("golden_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.GOLDEN));
	
	// Other
	public static final RegistryObject<Block> GOLDEN_PORTAL = registerBlock("golden_portal", GoldenPortalBlock::new);
	
	// Helper functions
	private static <T extends Block> Function<RegistryObject<T>, Supplier<? extends Item>> goldenBlockItem()
	{
		return object -> () -> new BlockItem(object.get(), goldenTab());
	}
	
	private static Properties goldenTab()
	{
		return new Item.Properties().tab(GoldenExpansion.GOLDEN_TAB);
	}
			
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block)
	{
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item)
	{
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name, item.apply(obj));
		return obj;
	}
}
