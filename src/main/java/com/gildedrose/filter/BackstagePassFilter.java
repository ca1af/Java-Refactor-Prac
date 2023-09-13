package com.gildedrose.filter;

import com.gildedrose.Item;

public class BackstagePassFilter extends ItemFilter{
    @Override
    void filterItem(Item item) {
        if (isItemChanged) return;
        if (!item.name.contains("Backstage Pass")) return;
        if (isSellInUnderZero(item)) {
            item.quality = 0;
            markItemChanged();
            return;
        }
        increaseQualityBySellIn(item, item.sellIn);
        markItemChanged();
    }

    private boolean isSellInUnderZero(Item item) {
        return item.sellIn <= 0;
    }

    private void increaseQualityBySellIn(Item item, int sellIn){
        if (sellIn > 5 && sellIn <= 10) {
            item.quality += 2;
            return;
        }

        if (sellIn <= 5){
            item.quality += 3;
            return;
        }

        item.quality++;
    }
}
