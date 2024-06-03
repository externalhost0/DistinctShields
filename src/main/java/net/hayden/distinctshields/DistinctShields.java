package net.hayden.distinctshields;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.hayden.distinctshields.items.compats.BetterEndItems;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.hayden.distinctshields.util.ModCreativeTab;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistinctShields implements ModInitializer {

	public static final String MOD_ID = "distinctshields";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// only with mixins
	public static final Integer COOLDOWN_TICKS = 140;

	public static Identifier id(String key) {
		return new Identifier(MOD_ID, key);
	}

	@Override
	public void onInitialize() {

		ModCreativeTab.registerItemGroup();
		VanillaItems.registerModItems();
		if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
			NaturesSpiritItems.registerModItems();
		}
		if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
			DeeperDarkerItems.registerModItems();
		}

		if (FabricLoader.getInstance().isModLoaded("betterend")) {
			BetterEndItems.registerModItems();
		}

		LOGGER.info("Initialized Variant Shields!");
	}
}