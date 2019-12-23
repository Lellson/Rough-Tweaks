package lellson.roughTweaks.misc;

import net.minecraftforge.common.config.Configuration;

public class RoughConfig {
	
	public static final String ITEMS = "items";
	public static final String HEALAMOUNT = "heal_amount";
	public static final String GENERAL = "general";
	
	public static int salveHealCount;
	public static int plasterHealCount;
	public static int bandageHealCount;
	public static int medikitHealCount;
	public static int medikitEnchantedHealCount;
	
	public static float salveHealAmount;
	public static float plasterHealAmount;
	public static float bandageHealAmount;
	public static float medikitHealAmount;
	public static float medikitEnchantedHealAmount;
	
	public static int sleepHealAmount;
	public static boolean healthRegenOff;
	public static int dropChance;
	
	public RoughConfig(Configuration config) {
		
		config.load();
		
		config.addCustomCategoryComment(ITEMS, "Defines how often you're able to rightclick the item to heal yourself. Set the use count to 0 to disable the item.");
		
		salveHealCount = config.getInt("salveUseCount", ITEMS, 2, 0, Short.MAX_VALUE, "Use count for the salve item");
		plasterHealCount = config.getInt("plasterUseCount", ITEMS, 4, 0, Short.MAX_VALUE, "Use count for the plaster item");
		bandageHealCount = config.getInt("bandageUseCount", ITEMS, 6, 0, Short.MAX_VALUE, "Use count for the bandage item");
		medikitHealCount = config.getInt("medikitUseCount", ITEMS, 16, 0, Short.MAX_VALUE, "Use count for the medikit item");
		medikitEnchantedHealCount = config.getInt("medikitEnchantedUseCount", ITEMS, 16, 0, Short.MAX_VALUE, "Use count for the enchanted medikit item");
		
		config.addCustomCategoryComment(HEALAMOUNT, "Defines how much health the item restores on rightclick.");
		
		salveHealAmount = config.getFloat("salveHealAmount", HEALAMOUNT, 1F, 1F, Short.MAX_VALUE, "Salve heal amount");
		plasterHealAmount = config.getFloat("plasterHealAmount", HEALAMOUNT, 1F, 1F, Short.MAX_VALUE, "Plaster heal amount");
		bandageHealAmount = config.getFloat("bandageHealAmount", HEALAMOUNT, 1F, 1F, Short.MAX_VALUE, "Bandage heal amount");
		medikitHealAmount = config.getFloat("medikitHealAmount", HEALAMOUNT, 1F, 1F, Short.MAX_VALUE, "Medikit heal amount");
		medikitEnchantedHealAmount = config.getFloat("medikitEnchantedHealAmount", HEALAMOUNT, 1F, 1F, Short.MAX_VALUE, "Enchanted Medikit heal amount");
		
		sleepHealAmount = config.getInt("sleepHealAmount", GENERAL, 2, 0, Short.MAX_VALUE, "Amount of half hearts sleeping heals. Set to 0 to disable this feature");
		healthRegenOff = config.getBoolean("healthRegenOff", GENERAL, true, "Set to false to prevent this mod from setting the natural health regeneration gamerule to false on entering a world");
		dropChance = config.getInt("dropChance", GENERAL, 30, 0, Short.MAX_VALUE, "Chance 1 in X that a hostile entity drops either salve, a plaster or a bandage\nSet this to 0 if you want to disable entity drops");
		
		if (config.hasChanged())
			config.save();
	}
}
