package net.hayden.distinctshields.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static net.hayden.distinctshields.DistinctShields.MOD_ID;

public class ModItemTags {

    public static final TagKey<Item> SHIELDS = register("shields");

    private static TagKey<Item> register(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, name));
    }
}