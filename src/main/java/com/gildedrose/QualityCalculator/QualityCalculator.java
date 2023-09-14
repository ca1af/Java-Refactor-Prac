package com.gildedrose.QualityCalculator;

public class QualityCalculator {
    private static Integer quality = -1;

    private QualityCalculator() { throw  new IllegalArgumentException("유틸 클래스");
    }

    public static Integer getQuality() {
        return quality;
    }

    public static synchronized void doubleQualityByZeroSellIn(int sellIn) {
        if (sellIn <= 0) quality *= 2;
    }

    public static synchronized void doubleQualityByKeywordConjured(String keyWord) {
        if (keyWord.contains("Conjured")) quality *= 2;
    }

    public static synchronized void resetQuality() {
        quality = -1;
    }

    public static synchronized boolean brieCalculator(String keyword){
        return calculateByKeyword(keyword, keyword1 -> {
            if (keyword1.contains("Aged Brie")) {
                quality = -quality;
                return true;
            }
            return false;
        });
    }

    public static synchronized boolean calculateByKeyword(String keyword, CalculateStrategy calculateStrategy){
        return calculateStrategy.calculateByKeyword(keyword);
    }

}
