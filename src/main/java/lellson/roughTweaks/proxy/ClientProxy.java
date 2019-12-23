package lellson.roughTweaks.proxy;

import lellson.roughTweaks.items.RoughItems;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
		RoughItems.registerRenderers();
	}
}
