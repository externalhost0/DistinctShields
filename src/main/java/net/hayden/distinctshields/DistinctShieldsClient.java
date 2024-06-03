package net.hayden.distinctshields;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.hayden.distinctshields.items.compats.DeeperDarkerItems;
import net.hayden.distinctshields.items.VanillaItems;
import net.hayden.distinctshields.items.compats.NaturesSpiritItems;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import static com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient.renderBanner;
import static net.hayden.distinctshields.renderer.DistinctShieldsRenderer.registerShieldPredicates;

public class DistinctShieldsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        for (Item shields : VanillaItems.MOD_SHIELDS.values()) {
            registerShieldPredicates(shields);
            registerBanner(shields);
        }
        for (Item shields : NaturesSpiritItems.NS_SHIELDS.values()) {
            registerShieldPredicates(shields);
            registerBanner(shields);
        }
        for (Item shields : DeeperDarkerItems.DD_SHIELDS.values()) {
            registerShieldPredicates(shields);
            registerBanner(shields);
        }
    }
    public static ShieldEntityModel modelShield;

    private void registerBanner(Item shields) {
        @SuppressWarnings("deprecation")
        SpriteIdentifier BANNER_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(DistinctShields.MOD_ID, String.format("entity/%s_banner_shield_base", getWoodTypeName(shields))));
        @SuppressWarnings("deprecation")
        SpriteIdentifier BANNER_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier(DistinctShields.MOD_ID, String.format("entity/%s_banner_shield_base_nopattern", getWoodTypeName(shields))));

        EntityModelLayer banner_shield_model_layer = new EntityModelLayer(new Identifier(DistinctShields.MOD_ID, shields.getTranslationKey()),"main");
        EntityModelLayerRegistry.registerModelLayer(banner_shield_model_layer, ShieldEntityModel::getTexturedModelData);
        ShieldSetModelCallback.EVENT.register((loader) -> {
            modelShield = new ShieldEntityModel(loader.getModelPart(banner_shield_model_layer));
            return ActionResult.PASS;
        });
        BuiltinItemRendererRegistry.INSTANCE.register(shields, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
            renderBanner(stack, matrices, vertexConsumers, light, overlay, modelShield, BANNER_SHIELD_BASE, BANNER_SHIELD_BASE_NO_PATTERN);
            //The first five parameters are taken from the method, while the last 3 you provide yourself. You will provide the model, and then your 2 sprite identifiers in the order of SHIELD_NAME_BASE and then SHIELD_NAME_BASE_NOPATTERN.
        });
    }

    private String getWoodTypeName(Item shields) {
        return shields.toString().replace("_shield", "");
    }
}
