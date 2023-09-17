package com.gildedrose.filter;

import com.gildedrose.Item;

public class SulfurasFilter extends ItemFilter {
    @Override
    public void doFilter(Item item) {
        if (!item.name.contains("Sulfuras")) return;
        item.sellIn--;
        item.quality = 80; // 항상 80
        markItemChanged();
    }
}
