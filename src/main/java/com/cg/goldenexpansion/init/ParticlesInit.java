package com.cg.goldenexpansion.init;

import com.cg.goldenexpansion.GoldenExpansion;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticlesInit
{
	// Setup deferred register
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GoldenExpansion.MOD_ID);
	
	// Register particles
	public static final RegistryObject<SimpleParticleType> GOLDEN_PORTAL_PARTICLES = PARTICLE_TYPES.register("golden_portal_particles", () -> new SimpleParticleType(true));
}
