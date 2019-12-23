package lellson.roughTweaks.items;

import java.util.List;

import lellson.roughTweaks.RoughTweaks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = RoughTweaks.MODID)
public class RoughItemRegistry {

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		
		IForgeRegistry<Item> registry = event.getRegistry();
		for (Item object : RoughItems.ITEMS)
		{
			registry.register(object);
		}
	}
}
