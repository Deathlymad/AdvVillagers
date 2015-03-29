package com.Villagers.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAdvVillager extends RenderLiving {

	public RenderAdvVillager(ModelBase model, float shadowSize) {
		super(model, shadowSize);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity arg0) {
		return null;
		//return new ResourceLocation( "Villagers"+":textures/entity/AdvVillager/AdvVillager.png");
	}

}
