package lellson.roughTweaks.misc.factories;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import lellson.roughTweaks.misc.RoughConfig;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FactoryPlaster implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return (() -> RoughConfig.plasterHealCount > 0);
	}
}
