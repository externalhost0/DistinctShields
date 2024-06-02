package net.hayden.distinctshields.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.hayden.distinctshields.DistinctShields;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.hayden.distinctshields.DistinctShields.MOD_ID;

public class ModCreativeTab {

    public static final ItemGroup SHIELD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID, "distinctshields"),
            FabricItemGroup.builder().displayName(Text.translatable("distinctshields.item_group"))
                    .icon(() -> new ItemStack(VanillaItems.BAMBOO_SHIELD)).entries((context, entries) -> {
                for (Item item : VanillaItems.MOD_SHIELDS.values()) {
                    entries.add(item);
                }
                if(FabricLoader.getInstance().isModLoaded("natures_spirit")) {
                    for (Item item : NaturesSpiritItems.NS_SHIELDS.values()) {
                        entries.add(item);
                    }
                }
                if(FabricLoader.getInstance().isModLoaded("deeperdarker")) {
                    for (Item item : DeeperDarkerItems.DD_SHIELDS.values()) {
                        entries.add(item);
                    }
                }

            }).build());

    public static void registerItemGroup() {
        DistinctShields.LOGGER.info("Registering mod tab for " + DistinctShields.MOD_ID);
    }
}