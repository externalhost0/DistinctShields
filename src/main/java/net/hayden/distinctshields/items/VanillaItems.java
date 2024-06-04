package net.hayden.distinctshields.items;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hayden.distinctshields.DistinctShields;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class VanillaItems {
    public static Map<Identifier, Item> MOD_SHIELDS = Maps.newHashMap();
    public static final Item ACACIA_SHIELD = registerItem("acacia_shield", new DShieldItem(new FabricItemSettings(), Items.ACACIA_PLANKS));
    public static final Item BAMBOO_SHIELD = registerItem("bamboo_shield", new DShieldItem(new FabricItemSettings(), Items.BAMBOO_PLANKS));
    public static final Item BIRCH_SHIELD = registerItem("birch_shield", new DShieldItem(new FabricItemSettings(), Items.BIRCH_PLANKS));
    public static final Item CHERRY_SHIELD = registerItem("cherry_shield", new DShieldItem(new FabricItemSettings(), Items.CHERRY_PLANKS));
    public static final Item CRIMSON_SHIELD = registerItem("crimson_shield", new DShieldItem(new FabricItemSettings(), Items.CRIMSON_PLANKS));
    public static final Item DARK_OAK_SHIELD = registerItem("dark_oak_shield", new DShieldItem(new FabricItemSettings(), Items.DARK_OAK_PLANKS));
    public static final Item JUNGLE_SHIELD = registerItem("jungle_shield", new DShieldItem(new FabricItemSettings(), Items.JUNGLE_PLANKS));
    public static final Item MANGROVE_SHIELD = registerItem("mangrove_shield", new DShieldItem(new FabricItemSettings(), Items.MANGROVE_PLANKS));
    public static final Item OAK_SHIELD = registerItem("oak_shield", new DShieldItem(new FabricItemSettings(), Items.OAK_PLANKS));
//    public static final Item SPRUCE_SHIELD = registerItem("spruce_shield", new ShieldItem(new FabricItemSettings()));
    public static final Item WARPED_SHIELD = registerItem("warped_shield", new DShieldItem(new FabricItemSettings(), Items.WARPED_PLANKS));


    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(DistinctShields.MOD_ID, name);
        MOD_SHIELDS.put(identifier, item);
        return Registry.register(Registries.ITEM, new Identifier(DistinctShields.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DistinctShields.LOGGER.info("Registering vanilla items for " + DistinctShields.MOD_ID);
    }
}
