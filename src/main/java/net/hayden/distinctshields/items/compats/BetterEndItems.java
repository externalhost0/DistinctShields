package net.hayden.distinctshields.items.compats;

import com.google.common.collect.Maps;
import net.hayden.distinctshields.DistinctShields;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BetterEndItems {
    public static Map<Identifier, Item> BE_SHIELDS = Maps.newHashMap();
//    public static final Item DRAGON_TREE_SHIELD = registerItem("dragon_tree_shield", new DShieldItem(new FabricItemSettings(), EndBlocks.DRAGON_TREE));
//    public static final Item END_LOTUS_SHIELD = registerItem("end_lotus_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item HELIX_TREE_SHIELD = registerItem("helix_tree_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item JELLYSHROOM_SHIELD = registerItem("jellyshroom_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item LACUGROVE_SHIELD = registerItem("lacugrove_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item LUCERNIA_SHIELD = registerItem("lucernia_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item MOSSY_GLOWSHROOM_SHIELD = registerItem("mossy_glowshroom_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item PYTHADENDRON_SHIELD = registerItem("pythadendron_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item TENANEA_SHIELD = registerItem("tenanea_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));
//    public static final Item UMBRELLA_TREE_SHIELD = registerItem("umbrella_tree_shield", new DShieldItem(new FabricItemSettings(), DDBlocks.ECHO_SHIELD));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(DistinctShields.MOD_ID, name);
        BE_SHIELDS.put(identifier, item);
        return Registry.register(Registries.ITEM, new Identifier(DistinctShields.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DistinctShields.LOGGER.info("Registering better end items for " + DistinctShields.MOD_ID);
    }
}
