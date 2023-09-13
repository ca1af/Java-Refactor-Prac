package com.gildedrose.filter;

import com.gildedrose.Item;

import java.util.ArrayList;
import java.util.List;

public class Filters {
    private final List<ItemFilter> filters;

    public Filters() {
        this.filters = init();
    }
    public List<ItemFilter> init(){
        SulfurasFilter sulfurasFilter = new SulfurasFilter();
        AgedBrieFilter agedBrieFilter = new AgedBrieFilter();
        BackstagePassFilter backstagePassFilter = new BackstagePassFilter();
        ConjuredItemFilter conjuredItemFilter = new ConjuredItemFilter();
        NormalItemFilter normalItemFilter = new NormalItemFilter();
        List<ItemFilter> filterList = new ArrayList<>();
        filterList.add(sulfurasFilter);
        filterList.add(agedBrieFilter);
        filterList.add(backstagePassFilter);
        filterList.add(conjuredItemFilter);
        filterList.add(normalItemFilter);
        return filterList;
    }
    public void doFilter(Item item){
        for (ItemFilter filter : filters) {
            filter.filterItem(item);
        }
        ItemFilter.initItemBoolean();
    }
}
