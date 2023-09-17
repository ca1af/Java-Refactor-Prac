package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@Deprecated
class ItemTest {
    private static final String NAME = "DK";
    private static final Integer SELL_IN = 5;
    private static final Integer QUALITY = 10;
    private Item item;
    @BeforeEach
    void initItem(){
        item = new Item(NAME, SELL_IN, QUALITY);
    }
}
