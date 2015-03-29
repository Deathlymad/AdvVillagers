package com.Villagers.Main;

import net.minecraftforge.common.config.Configuration;

import com.Villagers.Entity.AdvVillager;
import com.Villagers.Model.ModelAdvVillager;
import com.Villagers.proxy.VillagersCommonProxy;
import com.Villagers.render.RenderAdvVillager;

import cpw.mods.fml.client.registry.RenderingRegistry;
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
			
	@SidedProxy(clientSide="com.Villagers.proxy.VillagersClientProxy", serverSide="com.Villagers.proxy.VillagersCommonProxy")
	public static VillagersCommonProxy proxy;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.save();
		

	    EntityRegistry.registerGlobalEntityID(AdvVillager.class,"AdvVillager",EntityRegistry.findGlobalUniqueEntityId(),  (255 << 16), (255 << 16)+ (200 << 8));
		//EntityRegistry.addSpawn("Advanced Villager", 100, 1, 32, EnumCreatureType.creature, BiomeGenBase.plains);
		
		RenderingRegistry.registerEntityRenderingHandler(AdvVillager.class, new RenderAdvVillager(new ModelAdvVillager(), 0.5f));
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
