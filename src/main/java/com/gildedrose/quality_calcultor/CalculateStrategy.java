package com.gildedrose.quality_calcultor;
@FunctionalInterface
public interface CalculateStrategy {
    boolean calculateByKeyword(String keyword);
}
