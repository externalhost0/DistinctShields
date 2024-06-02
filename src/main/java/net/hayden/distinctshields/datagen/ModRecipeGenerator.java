package net.hayden.distinctshields.datagen;

import com.kyanite.deeperdarker.content.DDBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hibiscus.naturespirit.registration.block_registration.HibiscusWoods;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    public static void offerWoodenShieldRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible shield, ItemConvertible plank) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, shield)
                .input('W', plank)
                .input('#', Items.IRON_INGOT)
                .pattern("W#W")
                .pattern("WWW")
                .pattern(" W ")
                .criterion("has_plank", VanillaRecipeProvider.conditionsFromItem(plank))
                .offerTo(exporter);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerWoodenShieldRecipe(exporter, VanillaItems.ACACIA_SHIELD, Items.ACACIA_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.BAMBOO_SHIELD, Items.BAMBOO_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.BIRCH_SHIELD, Items.BIRCH_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.CHERRY_SHIELD, Items.CHERRY_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.CRIMSON_SHIELD, Items.CRIMSON_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.DARK_OAK_SHIELD, Items.DARK_OAK_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.JUNGLE_SHIELD, Items.JUNGLE_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.MANGROVE_SHIELD, Items.MANGROVE_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.OAK_SHIELD, Items.OAK_PLANKS);
//        offerWoodenShieldRecipe(exporter, ModItems.SPRUCE_SHIELD, Items.SPRUCE_PLANKS);
        offerWoodenShieldRecipe(exporter, VanillaItems.WARPED_SHIELD, Items.WARPED_PLANKS);

        // natures spirit shields
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.ASPEN_SHIELD, HibiscusWoods.ASPEN.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.CEDAR_SHIELD, HibiscusWoods.CEDAR.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.COCONUT_SHIELD, HibiscusWoods.COCONUT.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.CYPRESS_SHIELD, HibiscusWoods.CYPRESS.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.FIR_SHIELD, HibiscusWoods.FIR.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.GHAF_SHIELD, HibiscusWoods.GHAF.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.JOSHUA_SHIELD, HibiscusWoods.JOSHUA.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.LARCH_SHIELD, HibiscusWoods.LARCH.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.MAHOGANY_SHIELD, HibiscusWoods.MAHOGANY.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.MAPLE_SHIELD, HibiscusWoods.MAPLE.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.OLIVE_SHIELD, HibiscusWoods.OLIVE.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.PALO_VERDE_SHIELD, HibiscusWoods.PALO_VERDE.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.REDWOOD_SHIELD, HibiscusWoods.REDWOOD.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.SAXAUL_SHIELD, HibiscusWoods.SAXAUL.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.SUGI_SHIELD, HibiscusWoods.SUGI.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.WILLOW_SHIELD, HibiscusWoods.WILLOW.getPlanks());
        offerWoodenShieldRecipe(exporter, NaturesSpiritItems.WISTERIA_SHIELD, HibiscusWoods.WISTERIA.getPlanks());

        // deeper and darker shield
        offerWoodenShieldRecipe(exporter, DeeperDarkerItems.ECHO_SHIELD, DDBlocks.ECHO_PLANKS);
        //

    }
}