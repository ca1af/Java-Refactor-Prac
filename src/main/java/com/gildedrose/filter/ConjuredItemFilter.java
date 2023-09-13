package com.gildedrose.filter;

import com.gildedrose.Item;

public class ConjuredItemFilter extends ItemFilter{

    @Override
    void filterItem(Item item) { // Conjured Aged Brie ???? 이거 어케함
        if (isItemChanged) return;
        if (!item.name.contains("Conjured")) return;
        this.doubleDecreaseQuality(item);
        if (item.sellIn <= 0) this.doubleDecreaseQuality(item);
        item.sellIn--;
        markItemChanged();
    }
}
