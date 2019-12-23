package lellson.roughTweaks;

import lellson.roughTweaks.items.RoughItemRegistry;
import lellson.roughTweaks.items.RoughItems;
import lellson.roughTweaks.misc.RoughConfig;
import lellson.roughTweaks.misc.RoughEvents;
import lellson.roughTweaks.proxy.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RoughTweaks.MODID, name = "Rough Tweaks", version = "1.0")
public class RoughTweaks {
	
	public static final String MODID = "roughtweaks";
	
	@Instance
	public static RoughTweaks INSTANCE;
	
	@SidedProxy(clientSide="lellson.roughTweaks.proxy.ClientProxy", serverSide="lellson.roughTweaks.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		new RoughConfig(config);
		
		new RoughEvents();
		new RoughItems();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RoughTweaks.proxy.registerRenderers();
	}
}
