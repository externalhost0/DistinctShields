package net.hayden.distinctshields.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.hayden.distinctshields.util.ModModels;
import net.hayden.distinctshields.util.ModTextureKey;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.TextureKey;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item shield : VanillaItems.MOD_SHIELDS.values()) {
            registerFabricShieldItem(itemModelGenerator, shield);
        }
        for (Item shield : NaturesSpiritItems.NS_SHIELDS.values()) {
            registerFabricShieldItem(itemModelGenerator, shield);
        }
        for (Item shield : DeeperDarkerItems.DD_SHIELDS.values()) {
            registerFabricShieldItem(itemModelGenerator, shield);
        }
    }

    private void registerFabricShieldItem(ItemModelGenerator itemModelGenerator, Item shield) {
        Identifier notblocking = ModelIds.getItemModelId(shield);
        Identifier blocking = ModelIds.getItemSubModelId(shield, "_blocking");

        JsonObject json = new JsonObject();
        json.addProperty("parent", "fabricshieldlib:item/fabric_banner_shield");

        JsonArray overrides = new JsonArray();
        JsonObject override = new JsonObject();
        JsonObject predicate = new JsonObject();
        predicate.addProperty("blocking", 1);
        override.add("predicate", predicate);
        override.addProperty("model", blocking.toString());
        overrides.add(override);
        json.add("overrides", overrides);
        itemModelGenerator.writer.accept(notblocking, () -> json);

        JsonObject json2 = new JsonObject();
        json2.addProperty("parent", "fabricshieldlib:item/fabric_banner_shield_blocking");
        JsonObject textures = new JsonObject();
        textures.addProperty("shield", notblocking.toString());
        json2.add("textures", textures);
        itemModelGenerator.writer.accept(blocking, () -> json2);
    }

    @Deprecated
    private void registerShieldItem(ItemModelGenerator itemModelGenerator, Item shield) {
        Identifier notblocking = ModelIds.getItemModelId(shield);
        Identifier blocking = ModelIds.getItemSubModelId(shield, "_blocking");

        JsonObject json = new JsonObject();
        json.addProperty("parent", "distinctshields:item/distinct_shield");
        json.addProperty("gui_light", "front");

        JsonObject textures = new JsonObject();
        textures.addProperty("shield", notblocking.toString());
        textures.addProperty("particle", "#shield");
        json.add("textures", textures);

        JsonArray overrides = new JsonArray();
        JsonObject override = new JsonObject();
        JsonObject predicate = new JsonObject();
        predicate.addProperty("blocking", 1);
        override.add("predicate", predicate);
        override.addProperty("model", blocking.toString());
        overrides.add(override);
        json.add("overrides", overrides);
        itemModelGenerator.writer.accept(notblocking, () -> json);

        JsonObject jsonObject2 = ModModels.SHIELD_BLOCKING.createJson(blocking, Map.of(ModTextureKey.SHIELD, notblocking, TextureKey.PARTICLE, notblocking));
        jsonObject2.addProperty("gui_light", "front");
        itemModelGenerator.writer.accept(blocking, () -> jsonObject2);
    }
}
