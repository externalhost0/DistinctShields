package net.hayden.distinctshields.items.compats;

import com.google.common.collect.Maps;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.hayden.distinctshields.DistinctShields;
import net.hayden.distinctshields.items.DShieldItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class DeeperDarkerItems {
    public static Map<Identifier, Item> DD_SHIELDS = Maps.newHashMap();
    public static final Item ECHO_SHIELD = registerItem("echo_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_PLANKS));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(DistinctShields.MOD_ID, name);
        DD_SHIELDS.put(identifier, item);
        return Registry.register(Registries.ITEM, new Identifier(DistinctShields.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DistinctShields.LOGGER.info("Registering deeper darker items for " + DistinctShields.MOD_ID);
    }
}
