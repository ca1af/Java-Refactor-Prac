package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Deprecated
class GildedRoseTest {
    private static Item ITEM;
    private static Item BORDER_ITEM;
    private static final String NAME = "DK";
    private static final Integer SELL_IN = 5;
    private static final Integer QUALITY = 5;
    private static final Integer ZERO = 0;
    private static GildedRose GILDED_ROSE;
    @BeforeEach
    void initItem(){
        ITEM = new Item(NAME, SELL_IN, QUALITY);
        BORDER_ITEM = new Item(NAME, ZERO, ZERO);
        GILDED_ROSE = new GildedRose(new Item[]{ITEM});
    }

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.fooFunc(new Item("foo", 0, 0));
        assertEquals("foo", app.getItems()[0].name);
    }

    @Test
    void itemInputTest() {
        Item[] items = GILDED_ROSE.getItems();
        assertEquals(items[0], ITEM);
    }

    @Test
    void itemSellInTest() {
        GILDED_ROSE.fooFunc(ITEM);
        assertEquals(ITEM.sellIn, SELL_IN - 1);
    }

    @Test
    void itemQualityTest(){
        GILDED_ROSE.fooFunc(ITEM);
        assertEquals(ITEM.quality, QUALITY - 1);
    }

    @Test
    void itemBorderTest() {
        GILDED_ROSE.fooFunc(BORDER_ITEM);
        assertEquals(ZERO, BORDER_ITEM.quality);
        assertEquals(BORDER_ITEM.sellIn, -1);
    }

}
