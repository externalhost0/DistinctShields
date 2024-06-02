package net.hayden.distinctshields.util;

import net.hayden.distinctshields.DistinctShields;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels extends Models {

    public static final Model SHIELD;
    public static final Model SHIELD_BLOCKING;

    static {
        SHIELD = createShieldModel(ModTextureKey.SHIELD, TextureKey.PARTICLE);
        SHIELD_BLOCKING = createBlockingShieldModel(ModTextureKey.SHIELD, TextureKey.PARTICLE);
    }

    public static Identifier getShieldItem(String id) {
        return new Identifier(DistinctShields.MOD_ID, "item/" + id);
    }

    private static Model createShieldModel(TextureKey... requiredTextures) {
        return new Model(Optional.of(getShieldItem("fabric_banner_shield")), Optional.empty(), requiredTextures);
    }

    private static Model createBlockingShieldModel(TextureKey... requiredTextures) {
        return new Model(Optional.of(getShieldItem("fabric_banner_shield_blocking")), Optional.empty(), requiredTextures);
    }
}