package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FilterTest {
    private FilterTestHelper testHelper;
    @BeforeEach
    void setUp() {
        testHelper = new FilterTestHelper();
    }


    @Test
    void sulfurasTest() {
        testHelper.setup("Sulfuras, Hand of Ragnaros", 0, 0);
        assertThat(testHelper.getQuality()).isEqualTo(80);
        assertThat(testHelper.getSellIn()).isEqualTo(-1);
    }

    @Test
    void brieTest() {
        testHelper.setup("Aged Brie for DK", 0, 0);
        assertThat(testHelper.getSellIn()).isEqualTo(-1);
        assertThat(testHelper.getQuality()).isEqualTo(1);
    }

    @Test
    void backstageTest_zero_SellIn() {
        testHelper.setup("Backstage Pass for DK", 0, 10);
        assertThat(testHelper.getQuality()).isZero();
    }

    @Test
    void backstageTest_sixToTen_sellIn() {
        testHelper.setup("Backstage Pass for DK", 6, 10);
        assertThat(testHelper.getQuality()).isEqualTo(12);
    }

    @Test
    void backstageTest_oneToFive_sellIn() {
        testHelper.setup("Backstage Pass for DK", 1, 10);
        assertThat(testHelper.getQuality()).isEqualTo(13);
    }

    @Test
    void conjuredTest() {
        testHelper.setup("Conjured item for DK", 1, 10);
        assertThat(testHelper.getQuality()).isEqualTo(8);
    }

    @Test
    void conjuredTest_noSellIn() {
        testHelper.setup("Conjured item for DK", 0, 10);
        assertThat(testHelper.getQuality()).isEqualTo(6);
    }

    @Test
    void conjuredTest_noSellIn_withNotEnoughQuality() {
        testHelper.setup("Conjured item for DK", 0, 3);
        assertThat(testHelper.getQuality()).isZero();
    }

    @Test
    void normalItemTest() {
        testHelper.setup("Normal Item", 5, 10);
        assertThat(testHelper.getSellIn()).isEqualTo(4);
        assertThat(testHelper.getQuality()).isEqualTo(9);
    }

    @Test
    void normalItemTest_noSellIn() {
        testHelper.setup("Normal Item", 0, 10);
        assertThat(testHelper.getSellIn()).isEqualTo(-1);
        assertThat(testHelper.getQuality()).isEqualTo(8);
    }

    @Test
    void conjured_AgedBrie_Test() {
        testHelper.setup("Conjured Aged Brie", 0, 10); //
    }

    @Test
    void sulfuras_brie_backstage_conjured_normal_mixtureTest() {
        //given
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 0);
        Item brie = new Item("Aged Brie for DK", 0, 0);
        Item backStage = new Item("Backstage Pass for DK", 0, 10);
        Item conjured = new Item("Conjured item for DK", 1, 10);
        Item normal = new Item("Normal Item", 5, 10);
        Item[] items = new Item[]{
            sulfuras, brie, backStage, conjured, normal
        };
        GildedRose gildedRose = new GildedRose(items);
        //when
        gildedRose.updateQuality();
        //then
        assertThat(sulfuras.quality).isEqualTo(80);
        assertThat(brie.quality).isEqualTo(1);
        assertThat(backStage.quality).isZero();
        assertThat(conjured.quality).isEqualTo(8);
        assertThat(normal.quality).isEqualTo(9);
    }
}
class FilterTestHelper {
    private Item item;

    public void setup(String name, int sellIn, int quality) {
        item = new Item(name, sellIn, quality);
        Item[] items = new Item[]{item};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }
}
