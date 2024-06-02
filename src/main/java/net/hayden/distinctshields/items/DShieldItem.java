package net.hayden.distinctshields.items;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class DShieldItem extends FabricBannerShieldItem {
    // itemclass that extends a simple shield, giving it some pre-filled settings
    public DShieldItem(Settings settings, Block planks) {
        super(settings, 100, 8, planks.asItem());
    }
    public DShieldItem(Settings settings, Item planks) {
        super(settings, 100, 8, planks);
    }

}
