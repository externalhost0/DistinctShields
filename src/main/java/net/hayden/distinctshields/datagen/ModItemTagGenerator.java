package net.hayden.distinctshields.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.hayden.distinctshields.util.ModItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        for (Item shields : VanillaItems.MOD_SHIELDS.values()) {
            getOrCreateTagBuilder(ModItemTags.SHIELDS).add(shields);
        }
        for (Item shields : NaturesSpiritItems.NS_SHIELDS.values()) {
            getOrCreateTagBuilder(ModItemTags.SHIELDS).add(shields);
        }
        for (Item shields : DeeperDarkerItems.DD_SHIELDS.values()) {
            getOrCreateTagBuilder(ModItemTags.SHIELDS).add(shields);
        }
    }
}