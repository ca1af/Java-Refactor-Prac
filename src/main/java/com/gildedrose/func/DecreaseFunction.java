package com.gildedrose.func;

import com.gildedrose.filter.ItemFilter;

@FunctionalInterface
public interface DecreaseFunction {
    int decrease(ItemFilter itemFilter);
}
