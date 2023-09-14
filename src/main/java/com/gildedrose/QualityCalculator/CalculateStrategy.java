package com.gildedrose.QualityCalculator;
@FunctionalInterface
public interface CalculateStrategy {
    boolean calculateByKeyword(String keyword);
}
