package com.gildedrose;

import com.gildedrose.filter.Filters;

class GildedRose {
    private final Filters filters;
    private final Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
        this.filters = new Filters();
    }

    public void updateQuality(){
        for (Item item : items) {
            filters.doFilter(item);
        }
    }

    /**
     * @deprecated 실험용
     */
    @Deprecated
    public void fooFunc(Item item) {
        item.sellIn--;
        if (item.quality > 0){
            item.quality--;
        }
    }
}
