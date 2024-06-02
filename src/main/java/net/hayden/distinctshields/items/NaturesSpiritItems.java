package net.hayden.distinctshields.items;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hayden.distinctshields.DistinctShields;
import net.hibiscus.naturespirit.registration.block_registration.HibiscusWoods;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class NaturesSpiritItems {

    public static Map<Identifier, Item> NS_SHIELDS = Maps.newHashMap();
    public static final Item ASPEN_SHIELD = registerItem("aspen_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.ASPEN.getPlanks()));
    public static final Item CEDAR_SHIELD = registerItem("cedar_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.CEDAR.getPlanks()));
    public static final Item COCONUT_SHIELD = registerItem("coconut_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.COCONUT.getPlanks()));
    public static final Item CYPRESS_SHIELD = registerItem("cypress_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.CYPRESS.getPlanks()));
    public static final Item FIR_SHIELD = registerItem("fir_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.FIR.getPlanks()));
    public static final Item GHAF_SHIELD = registerItem("ghaf_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.GHAF.getPlanks()));
    public static final Item JOSHUA_SHIELD = registerItem("joshua_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.JOSHUA.getPlanks()));
    public static final Item LARCH_SHIELD = registerItem("larch_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.LARCH.getPlanks()));
    public static final Item MAHOGANY_SHIELD = registerItem("mahogany_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.MAHOGANY.getPlanks()));
    public static final Item MAPLE_SHIELD = registerItem("maple_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.MAPLE.getPlanks()));
    public static final Item OLIVE_SHIELD = registerItem("olive_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.OLIVE.getPlanks()));
    public static final Item PALO_VERDE_SHIELD = registerItem("palo_verde_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.PALO_VERDE.getPlanks()));
    public static final Item REDWOOD_SHIELD = registerItem("redwood_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.REDWOOD.getPlanks()));
    public static final Item SAXAUL_SHIELD = registerItem("saxaul_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.SAXAUL.getPlanks()));
    public static final Item SUGI_SHIELD = registerItem("sugi_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.SUGI.getPlanks()));
    public static final Item WILLOW_SHIELD = registerItem("willow_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.WILLOW.getPlanks()));
    public static final Item WISTERIA_SHIELD = registerItem("wisteria_shield", new DShieldItem(new FabricItemSettings(), HibiscusWoods.WISTERIA.getPlanks()));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(DistinctShields.MOD_ID, name);
        NS_SHIELDS.put(identifier, item);
        return Registry.register(Registries.ITEM, new Identifier(DistinctShields.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DistinctShields.LOGGER.info("Registering mod items for " + DistinctShields.MOD_ID);
    }
}
