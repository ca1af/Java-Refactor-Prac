package com.gildedrose.filter;

import com.gildedrose.Item;

public class ConjuredItemFilter extends ItemFilter{

    @Override
    protected void doFilter(Item item) {
        if (!item.name.contains("Conjured")) return;
        this.doubleDecreaseQuality(item);
        if (item.sellIn <= 0) this.doubleDecreaseQuality(item);
        item.sellIn--;
        markItemChanged();
    }
}
