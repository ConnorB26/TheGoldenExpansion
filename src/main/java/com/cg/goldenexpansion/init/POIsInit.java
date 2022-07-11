package com.cg.goldenexpansion.init;

import java.lang.reflect.InvocationTargetException;

import com.cg.goldenexpansion.GoldenExpansion;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class POIsInit
{
	// Setup deferred register
	public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, GoldenExpansion.MOD_ID);
	
	// Register portal
	public static final RegistryObject<PoiType> GOLDEN_PORTAL = POI.register("golden_portal", () -> new PoiType(ImmutableSet.copyOf(BlockInit.GOLDEN_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));

	public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, POIsInit.GOLDEN_PORTAL.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}