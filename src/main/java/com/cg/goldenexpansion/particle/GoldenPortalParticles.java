package com.cg.goldenexpansion.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GoldenPortalParticles extends TextureSheetParticle
{
	private final double xStart;
	private final double yStart;
	private final double zStart;
	
	protected GoldenPortalParticles(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet, double xd, double yd, double zd)
	{
		super(level, xCoord, yCoord, zCoord, xd, yd, zd);
		
		this.friction = 0.5f;
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;
		this.xStart = this.x;
	    this.yStart = this.y;
	    this.zStart = this.z;
		this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.5F);
		this.lifetime = (int)(Math.random() * 10.0D) + 40;
		this.setSpriteFromAge(spriteSet);
		float f = this.random.nextFloat() * 0.6F + 0.4F;
	    this.rCol = f;
	    this.gCol = f;
	    this.bCol = f;
	}
	
	@Override
	public void tick() {
	      this.xo = this.x;
	      this.yo = this.y;
	      this.zo = this.z;
	      if (this.age++ >= this.lifetime) {
	         this.remove();
	      } else {
	         float f = (float)this.age / (float)this.lifetime;
	         float f1 = -f + f * f * 2.0F;
	         float f2 = 1.0F - f1;
	         this.x = this.xStart + this.xd * (double)f2;
	         this.y = this.yStart + this.yd * (double)f2 + (double)(1.0F - f);
	         this.z = this.zStart + this.zd * (double)f2;
	      }
	   }
	
	public float getQuadSize(float p_107567_) {
	      float f = ((float)this.age + p_107567_) / (float)this.lifetime;
	      f = 1.0F - f;
	      f *= f;
	      f = 1.0F - f;
	      return this.quadSize * f;
	   }
	
	public void move(double p_107560_, double p_107561_, double p_107562_) {
	      this.setBoundingBox(this.getBoundingBox().move(p_107560_, p_107561_, p_107562_));
	      this.setLocationFromBoundingbox();
	   }

	@Override
	public ParticleRenderType getRenderType()
	{
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}
	
	@OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType>
	{
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet)
        {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double dx, double dy, double dz)
        {
            return new GoldenPortalParticles(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
