package com.gildedrose.filter;

import com.gildedrose.Item;

public class AgedBrieFilter extends ItemFilter{

    @Override
    void filterItem(Item item) {
        if (!item.name.contains("Aged Brie")) return;
        item.sellIn--;
        if (item.quality < 50 ) item.quality++;
        markItemChanged();
    }
}
