package com.cg.goldenexpansion.datagen.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.block.plants.crops.GoldenBeetrootBlock;
import com.cg.goldenexpansion.block.plants.crops.GoldenCarrotBlock;
import com.cg.goldenexpansion.block.plants.crops.GoldenPotatoBlock;
import com.cg.goldenexpansion.block.plants.crops.GoldenWheatBlock;
import com.cg.goldenexpansion.init.BlockInit;
import com.google.common.base.Function;

import net.minecraft.core.Direction.Axis;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider
{
	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper)
	{
		super(generator, GoldenExpansion.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels()
	{
		// Crops
		int[] threeStagePlant = new int[]{0, 0, 1, 1, 2, 2, 2, 3};
		int[] sevenStagePlant = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
		makeCrop((GoldenPotatoBlock)BlockInit.GOLDEN_POTATOES.get(), "golden_potatoes_stage", "golden_potatoes_stage", threeStagePlant);
		makeCrop((GoldenCarrotBlock)BlockInit.GOLDEN_CARROTS.get(), "golden_carrots_stage", "golden_carrots_stage", threeStagePlant);
		makeCrop((GoldenWheatBlock)BlockInit.GOLDEN_WHEAT.get(), "golden_wheat_stage", "golden_wheat_stage", sevenStagePlant);
		makeCrop((GoldenBeetrootBlock)BlockInit.GOLDEN_BEETROOTS.get(), "golden_beetroots_stage", "golden_beetroots_stage", sevenStagePlant);
		
		// Bushes
		makeBush((SweetBerryBushBlock)BlockInit.BLUEBERRY_BUSH.get(), "blueberry_bush_stage", "blueberry_bush_stage");
		makeBush((SweetBerryBushBlock)BlockInit.GOLDEN_BLUEBERRY_BUSH.get(), "golden_blueberry_bush_stage", "golden_blueberry_bush_stage");
		makeBush((SweetBerryBushBlock)BlockInit.GOLDEN_SWEET_BERRY_BUSH.get(), "golden_sweet_berry_bush_stage", "golden_sweet_berry_bush_stage");
		
		// Stems
		makeStem((StemBlock)BlockInit.GOLDEN_MELON_STEM.get(), "golden_melon_stem_stage", "golden_melon_stem");
		makeStem((StemBlock)BlockInit.GOLDEN_PUMPKIN_STEM.get(), "golden_pumpkin_stem_stage", "golden_melon_stem");
		horizontalBlock(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get(), models().withExistingParent(getBlockPath(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get()), "block/stem_fruit")
				.texture("stem", modLoc("block/golden_melon_stem")).texture("upperstem", modLoc("block/attached_golden_melon_stem")), 270);
		horizontalBlock(BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), models().getExistingFile(modLoc("block/attached_golden_melon_stem")));
		simpleBlock(BlockInit.GOLDEN_MELON.get(), models().cubeColumn(getBlockPath(BlockInit.GOLDEN_MELON.get()), modLoc("block/golden_melon_side"), modLoc("block/golden_melon_top")));
		simpleBlock(BlockInit.GOLDEN_PUMPKIN.get(), models().cubeColumn(getBlockPath(BlockInit.GOLDEN_PUMPKIN.get()), modLoc("block/golden_pumpkin_side"), modLoc("block/golden_pumpkin_top")));
		horizontalBlock(BlockInit.GOLDEN_CARVED_PUMPKIN.get(), models().orientable(getBlockPath(BlockInit.GOLDEN_CARVED_PUMPKIN.get()), modLoc("block/golden_pumpkin_side"), modLoc("block/golden_carved_pumpkin"), modLoc("block/golden_pumpkin_top")));
		horizontalBlock(BlockInit.GOLDEN_JACK_O_LANTERN.get(), models().orientable(getBlockPath(BlockInit.GOLDEN_JACK_O_LANTERN.get()), modLoc("block/golden_pumpkin_side"), modLoc("block/golden_jack_o_lantern"), modLoc("block/golden_pumpkin_top")));
		
		// Wood stuff
        simpleBlock(BlockInit.GOLDEN_LEAVES.get());
        simpleBlock(BlockInit.GOLDEN_PLANKS.get());
		
		ResourceLocation planksRL = blockTexture(BlockInit.GOLDEN_PLANKS.get());
        logBlock((RotatedPillarBlock)BlockInit.GOLDEN_LOG.get());
        axisBlock((RotatedPillarBlock)BlockInit.GOLDEN_WOOD.get(), blockTexture(BlockInit.GOLDEN_LOG.get()), blockTexture(BlockInit.GOLDEN_LOG.get()));
        axisBlock((RotatedPillarBlock)BlockInit.STRIPPED_GOLDEN_LOG.get(), modLoc("block/stripped_golden_log"), modLoc("block/stripped_golden_log_top"));
        axisBlock((RotatedPillarBlock)BlockInit.STRIPPED_GOLDEN_WOOD.get(), modLoc("block/stripped_golden_log"), modLoc("block/stripped_golden_log"));
        signBlock((StandingSignBlock)BlockInit.GOLDEN_SIGN.get(), (WallSignBlock)BlockInit.GOLDEN_WALL_SIGN.get(), planksRL);
        buttonBlock((ButtonBlock)BlockInit.GOLDEN_BUTTON.get(), planksRL);
        pressurePlateBlock((PressurePlateBlock)BlockInit.GOLDEN_WOODEN_PRESSURE_PLATE.get(), planksRL);
        fenceBlock((FenceBlock)BlockInit.GOLDEN_FENCE.get(), planksRL);
        fenceGateBlock((FenceGateBlock)BlockInit.GOLDEN_FENCE_GATE.get(), planksRL);
        slabBlock((SlabBlock)BlockInit.GOLDEN_SLAB.get(), planksRL, planksRL);
        stairsBlock((StairBlock)BlockInit.GOLDEN_STAIRS.get(), planksRL);
        trapdoorBlock((TrapDoorBlock)BlockInit.GOLDEN_WOODEN_TRAPDOOR.get(), blockTexture(BlockInit.GOLDEN_WOODEN_TRAPDOOR.get()), true);
        doorBlock((DoorBlock)BlockInit.GOLDEN_WOODEN_DOOR.get(), modLoc("block/golden_wooden_door_bottom"), modLoc("block/golden_wooden_door_top"));
        
        models().getBuilder("block/golden_button_inventory").parent(models().getExistingFile(mcLoc("block/button_inventory"))).texture("texture", planksRL);
        models().getBuilder("block/golden_fence_inventory").parent(models().getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", planksRL);
        
        ResourceLocation craftingTableRL = modLoc("block/golden_crafting_table");
        simpleBlock(BlockInit.GOLDEN_CRAFTING_TABLE.get(), models().cube("golden_crafting_table", planksRL,
        		extend(craftingTableRL, "_top"), extend(craftingTableRL, "_front"), extend(craftingTableRL, "_side"),
        		extend(craftingTableRL, "_side"), extend(craftingTableRL, "_top")).texture("particle", extend(craftingTableRL, "_front")));
        
        simpleBlock(BlockInit.GOLDEN_SAPLING.get(), models().cross(getBlockPath(BlockInit.GOLDEN_SAPLING.get()), blockTexture(BlockInit.GOLDEN_SAPLING.get())));
		simpleBlock(BlockInit.POTTED_GOLDEN_SAPLING.get(), models().withExistingParent(getBlockPath(BlockInit.POTTED_GOLDEN_SAPLING.get()), "flower_pot_cross")
				.texture("plant", modLoc("block/golden_sapling")));
		
		// Portal
		getVariantBuilder(BlockInit.GOLDEN_PORTAL.get())
		        .partialState().with(NetherPortalBlock.AXIS, Axis.Z)
		            .modelForState().modelFile(models().getExistingFile(modLoc("block/golden_portal_ew"))).addModel()
		        .partialState().with(NetherPortalBlock.AXIS, Axis.X)
		            .modelForState().modelFile(models().getExistingFile(modLoc("block/golden_portal_ns"))).addModel();
	}
	
	// Helper functions
    private ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
	
	private String getBlockPath(Block b)
	{
		return ForgeRegistries.BLOCKS.getKey(b).getPath();
	}

	// Crop helper functions
	public void makeCrop(CropBlock block, String modelName, String textureName, int[] stages)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName, stages);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName, int[] stages)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + stages[state.getValue(block.getAgeProperty())],
                new ResourceLocation(GoldenExpansion.MOD_ID, "block/" + textureName + stages[state.getValue(block.getAgeProperty())])));

        return models;
    }
    
    // Bush helper functions
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> statesBush(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesBush(BlockState state, SweetBerryBushBlock block, String modelName, String textureName)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(SweetBerryBushBlock.AGE),
                new ResourceLocation(GoldenExpansion.MOD_ID, "block/" + textureName + state.getValue(SweetBerryBushBlock.AGE))));

        return models;
    }
    
    // Stem helper functions
    public void makeStem(StemBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> statesStem(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesStem(BlockState state, StemBlock block, String modelName, String textureName)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().getBuilder(modelName + state.getValue(StemBlock.AGE))
        		.parent(models().getExistingFile(mcLoc("block/stem_growth" + state.getValue(StemBlock.AGE)))).texture("stem", "block/" + textureName));

        return models;
    }
}