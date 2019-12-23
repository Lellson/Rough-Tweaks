package lellson.roughTweaks.misc.factories;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import lellson.roughTweaks.misc.RoughConfig;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class FactoryMedikit implements IConditionFactory {

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return (() -> RoughConfig.medikitHealCount > 0 && RoughConfig.bandageHealCount > 0 && RoughConfig.salveHealCount > 0 && RoughConfig.plasterHealCount > 0);
	}
}
