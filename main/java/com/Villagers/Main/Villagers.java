package com.Villagers.Main;

import net.minecraftforge.common.config.Configuration;

import com.deathlymad.Death.proxy.RecipeBluePrintsCommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Villagers.MODID, version = Villagers.VERSION)
public class Villagers {
	public static final String MODID = "Villagers";
	public static final String VERSION = "";

	@Instance(value="Villagers")
	public final Villagers instance = this;
			
	@SidedProxy(clientSide="com.deathlymad.DeathPatch.proxy.DeathPatchClientProxy", serverSide="com.deathlymad.DeathPatch.proxy.DeathPatchCommonProxy")
	public static RecipeBluePrintsCommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.save();
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
		
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
	}
		
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
