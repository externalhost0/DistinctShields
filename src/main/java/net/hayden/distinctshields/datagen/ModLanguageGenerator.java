package net.hayden.distinctshields.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.loader.api.FabricLoader;
import net.hayden.distinctshields.DistinctShields;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModLanguageGenerator extends FabricLanguageProvider {
    public ModLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static String generateItemDisplayName(Item item) {
        Identifier name = Registries.ITEM.getId(item);
        String itemName = name.getPath();
        String[] parts = itemName.split("_");
        StringBuilder displayName = new StringBuilder();
        for (String part : parts) {
            displayName.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        }
        return displayName.toString().trim();
    }
    private String generateItemDisplayName(Item item, String color) {
        return color + " " + generateItemDisplayName(item);
    }

    private static final String[] DYE_COLORS = {
            "Red", "Orange", "Yellow", "Lime", "Green", "Light Blue", "Cyan",
            "Blue", "Purple", "Magenta", "Pink", "Brown", "White",
            "Light Gray", "Gray", "Dark Gray", "Black" };

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        for (Item item : VanillaItems.MOD_SHIELDS.values()) {
            translationBuilder.add(item, generateItemDisplayName(item));
            // generates color translation for each value
            for (String color : DYE_COLORS) {
                translationBuilder.add("item." + DistinctShields.MOD_ID + "." + item + "." + color.toLowerCase(), generateItemDisplayName(item, color));
            }
        }
        if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
            for (Item item : NaturesSpiritItems.NS_SHIELDS.values()) {
                translationBuilder.add(item, generateItemDisplayName(item));
                for (String color : DYE_COLORS) {
                    translationBuilder.add("item." + DistinctShields.MOD_ID + "." + item + "." + color.toLowerCase(), generateItemDisplayName(item, color));
                }
            }
        }
        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
            for (Item item : DeeperDarkerItems.DD_SHIELDS.values()) {
                translationBuilder.add(item, generateItemDisplayName(item));
                for (String color : DYE_COLORS) {
                    translationBuilder.add("item." + DistinctShields.MOD_ID + "." + item + "." + color.toLowerCase(), generateItemDisplayName(item, color));
                }
            }
        }

        translationBuilder.add("distinctshields.resourcepacks", "Rename Shield to Oak");
        translationBuilder.add("distinctshields.item_group", "Distinct Shields");
        translationBuilder.add("distinctshields.cooldown", "Cooldown");
    }
}
