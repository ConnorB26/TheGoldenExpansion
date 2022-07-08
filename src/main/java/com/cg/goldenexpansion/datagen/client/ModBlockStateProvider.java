package com.cg.goldenexpansion.datagen.client;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.init.BlockInit;
import com.google.common.base.Function;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
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
import net.minecraftforge.client.model.generators.ModelFile;
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
		makeCrop((CropBlock)BlockInit.GOLDEN_POTATOES.get(), "golden_potatoes_stage", "golden_potatoes_stage");
		makeCrop((CropBlock)BlockInit.GOLDEN_WHEAT.get(), "golden_wheat_stage", "golden_wheat_stage");
		makeCrop((CropBlock)BlockInit.GOLDEN_BEETROOTS.get(), "golden_beetroots_stage", "golden_beetroots_stage");
		makeCrop((CropBlock)BlockInit.GOLDEN_CARROTS.get(), "golden_carrots_stage", "golden_carrots_stage");
		
		// Bushes
		makeBush((SweetBerryBushBlock)BlockInit.BLUEBERRY_BUSH.get(), "blueberry_bush_stage", "blueberry_bush_stage");
		makeBush((SweetBerryBushBlock)BlockInit.GOLDEN_BLUEBERRY_BUSH.get(), "golden_blueberry_bush_stage", "golden_blueberry_bush_stage");
		makeBush((SweetBerryBushBlock)BlockInit.GOLDEN_SWEET_BERRY_BUSH.get(), "golden_sweet_berry_bush_stage", "golden_sweet_berry_bush_stage");
		
		// Stems
		makeStem((StemBlock)BlockInit.GOLDEN_MELON_STEM.get(), "golden_melon_stem_stage", "golden_melon_stem");
		makeStem((StemBlock)BlockInit.GOLDEN_PUMPKIN_STEM.get(), "golden_pumpkin_stem_stage", "golden_melon_stem");
		horizontalBlock(BlockInit.ATTACHED_GOLDEN_MELON_STEM.get(), models().getBuilder("attached_golden_melon_stem").parent(models().getExistingFile(mcLoc("block/stem_fruit")))
				.texture("stem", modLoc("block/golden_melon_stem")).texture("upperstem", modLoc("block/attached_golden_melon_stem")), 270);
		horizontalBlock(BlockInit.ATTACHED_GOLDEN_PUMPKIN_STEM.get(), models().getExistingFile(modLoc("block/attached_golden_melon_stem")));
		simpleBlock(BlockInit.GOLDEN_MELON.get(), models().cubeColumn("golden_melon", modLoc("block/golden_melon_side"), modLoc("block/golden_melon_top")));
		simpleBlock(BlockInit.GOLDEN_PUMPKIN.get(), models().cubeColumn("golden_pumpkin", modLoc("block/golden_pumpkin_side"), modLoc("block/golden_pumpkin_top")));
		
		// Other
		simpleBlock(BlockInit.GOLDEN_SAPLING.get(), models().cross(getBlockPath(BlockInit.GOLDEN_SAPLING.get()).getPath(), blockTexture(BlockInit.GOLDEN_SAPLING.get())));
		simpleBlock(BlockInit.POTTED_GOLDEN_SAPLING.get(), flowerPotCross(getBlockPath(BlockInit.POTTED_GOLDEN_SAPLING.get()).getPath()));
		
		// Wood stuff
		ResourceLocation planksRL = blockTexture(BlockInit.GOLDEN_PLANKS.get());
		
        logBlock((RotatedPillarBlock)BlockInit.GOLDEN_LOG.get());
        axisBlock((RotatedPillarBlock)BlockInit.GOLDEN_WOOD.get(), blockTexture(BlockInit.GOLDEN_LOG.get()), blockTexture(BlockInit.GOLDEN_LOG.get()));
        axisBlock((RotatedPillarBlock)BlockInit.STRIPPED_GOLDEN_LOG.get(), modLoc("block/stripped_golden_log"), modLoc("block/stripped_golden_log_top"));
        axisBlock((RotatedPillarBlock)BlockInit.STRIPPED_GOLDEN_WOOD.get(), modLoc("block/stripped_golden_log"), modLoc("block/stripped_golden_log"));
        signBlock((StandingSignBlock)BlockInit.GOLDEN_SIGN.get(), (WallSignBlock)BlockInit.GOLDEN_WALL_SIGN.get(), planksRL);
        buttonBlock((ButtonBlock)BlockInit.GOLDEN_BUTTON.get(), planksRL);
        pressurePlateBlock((PressurePlateBlock)BlockInit.GOLDEN_PRESSURE_PLATE.get(), planksRL);
        fenceBlock((FenceBlock)BlockInit.GOLDEN_FENCE.get(), planksRL);
        fenceGateBlock((FenceGateBlock)BlockInit.GOLDEN_FENCE_GATE.get(), planksRL);
        slabBlock((SlabBlock)BlockInit.GOLDEN_SLAB.get(), planksRL, planksRL);
        stairsBlock((StairBlock)BlockInit.GOLDEN_STAIRS.get(), planksRL);
        trapdoorBlock((TrapDoorBlock)BlockInit.GOLDEN_TRAPDOOR.get(), blockTexture(BlockInit.GOLDEN_TRAPDOOR.get()), true);
        
        ResourceLocation doorBottomRL = modLoc("block/golden_door_bottom");
        ResourceLocation doorTopRL = modLoc("block/golden_door_top");
        createDoorModel("golden_door", "_bottom_left", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_bottom_left_open", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_bottom_right", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_bottom_right_open", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_top_left", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_top_left_open", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_top_right", doorBottomRL, doorTopRL);
        createDoorModel("golden_door", "_top_right_open", doorBottomRL, doorTopRL);
        
        simpleBlock(BlockInit.GOLDEN_LEAVES.get());
        simpleBlock(BlockInit.GOLDEN_PLANKS.get());
        
        ResourceLocation craftingTableRL = modLoc("block/golden_crafting_table");
        simpleBlock(BlockInit.GOLDEN_CRAFTING_TABLE.get(), models().cube("golden_crafting_table", planksRL,
        		extend(craftingTableRL, "_top"), extend(craftingTableRL, "_front"), extend(craftingTableRL, "_side"),
        		extend(craftingTableRL, "_side"), extend(craftingTableRL, "_top")).texture("particle", extend(craftingTableRL, "_front")));
	}
	
	// Helper functions
    private ResourceLocation extend(ResourceLocation rl, String suffix)
    {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
	
	private ResourceLocation getBlockPath(Block b)
	{
		return ForgeRegistries.BLOCKS.getKey(b);
	}
	
	// Create door model from scratch since Forge one doesn't work
	private void createDoorModel(String originalName, String suffix, ResourceLocation bottomTexture, ResourceLocation topTexture)
	{
		models().getBuilder(originalName + suffix).parent(models().getExistingFile(mcLoc("block/door" + suffix))).texture("bottom", bottomTexture).texture("top", topTexture);
	}
	
	public ModelFile flowerPotCross(String name)
	{
        return models().withExistingParent(name, "flower_pot_cross");
    }

	// Crop helper functions
    public void makeCrop(CropBlock block, String modelName, String textureName)
    {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName)
    {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(GoldenExpansion.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

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
        		.parent(models().getExistingFile(mcLoc("block/stem_growth" + state.getValue(StemBlock.AGE)))).texture("stem", textureName));

        return models;
    }
}