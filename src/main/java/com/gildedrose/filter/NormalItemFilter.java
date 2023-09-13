package com.gildedrose.filter;

import com.gildedrose.Item;

public class NormalItemFilter extends ItemFilter {

    @Override
    public void filterItem(Item item) {
        if (isItemChanged) return;
        item.sellIn--;
        if (isSellInUnderZero(item)) {
            doubleDecreaseQuality(item);
            return;
        }
        decreaseQuality(item);
        markItemChanged();
    }

    private boolean isSellInUnderZero(Item item){
        return item.sellIn <= 0;
    }
}
