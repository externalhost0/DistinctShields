package net.hayden.distinctshields.util;

import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.hayden.distinctshields.DistinctShields;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.NaturesSpiritItems;
import net.minecraft.item.Item;

import java.io.FileWriter;
import java.io.IOException;

public class ModAtlasesGen {
    // helper function to write atlases
    public static void generateBlocksJson() {
        // List of wood types
        JsonObject json = new JsonObject();
        JsonArray sources = new JsonArray();
        for (Item shields : Iterables.concat(VanillaItems.MOD_SHIELDS.values(), NaturesSpiritItems.NS_SHIELDS.values())) {
            JsonObject source = new JsonObject();
            source.addProperty("type", "single");
            source.addProperty("resource", String.format("%s:entity/%s_banner_shield_base", DistinctShields.MOD_ID, DistinctShields.getWoodTypeName(shields)));
            sources.add(source);
            JsonObject source2 = new JsonObject();
            source2.addProperty("type", "single");
            source2.addProperty("resource", String.format("%s:entity/%s_banner_shield_base_nopattern", DistinctShields.MOD_ID, DistinctShields.getWoodTypeName(shields)));
            sources.add(source2);
            json.add("sources", sources);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("/Users/hayde/Documents/distinctshields/src/main/resources/assets/minecraft/atlases/blocks.json")) {
            writer.write(gson.toJson(json));
            System.out.println("Blocks.json file has been created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
