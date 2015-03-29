package com.deathlymad.DeathPatch;

import net.minecraftforge.common.config.Configuration;

import com.deathlymad.Death.proxy.RecipeBluePrintsCommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = DeathPatch.MODID, version = DeathPatch.VERSION)
public class DeathPatch {
    public static final String MODID = "DeathPatch";
    public static final String VERSION = "";

	@Instance(value="RecipeBluePrints")
	public final DeathPatch instance = this;
		
	@SidedProxy(clientSide="com.deathlymad.DeathPatch.proxy.DeathPatchClientProxy", serverSide="com.deathlymad.DeathPatch.proxy.DeathPatchCommonProxy")
	public static RecipeBluePrintsCommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		config.save();
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
