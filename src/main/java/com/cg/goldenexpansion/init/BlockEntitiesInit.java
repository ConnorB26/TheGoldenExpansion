package com.cg.goldenexpansion.init;

import com.cg.goldenexpansion.GoldenExpansion;
import com.cg.goldenexpansion.block.entity.ModSignBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntitiesInit
{
	// Setup deferred register
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, GoldenExpansion.MOD_ID);
	
	// Signs
	public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES = BLOCK_ENTITIES.register("sign_block_entity",
			() -> BlockEntityType.Builder.of(ModSignBlockEntity::new, BlockInit.GOLDEN_SIGN.get(), BlockInit.GOLDEN_WALL_SIGN.get()).build(null));
}
