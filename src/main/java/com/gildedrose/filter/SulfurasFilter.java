package com.gildedrose.filter;

import com.gildedrose.Item;

public class SulfurasFilter extends ItemFilter {
    @Override
    public void filterItem(Item item) {
        if (isItemChanged) return; // 만약 이미 바뀐 상태라면 다시 바꿔줌
        if (!item.name.contains("Sulfuras")) return;
        item.sellIn--;
        item.quality = 80; // 항상 80
        markItemChanged();
    }
}
