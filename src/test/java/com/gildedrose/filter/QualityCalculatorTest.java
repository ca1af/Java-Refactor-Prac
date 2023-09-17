package com.gildedrose.filter;

import com.gildedrose.quality_calcultor.QualityCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QualityCalculatorTest {
    @BeforeEach
    void resetQuality() {
        QualityCalculator.resetQuality();
    }

    @Test
    void quality_constant_to_multipy_test() {
        QualityCalculator.doubleQualityByZeroSellIn(0);

        assertThat(QualityCalculator.getQuality()).isEqualTo(-2);
    }

    @Test
    void quality_multiply_by_Conjured() {
        QualityCalculator.doubleQualityByKeywordConjured("Conjured");
        assertThat(QualityCalculator.getQuality()).isEqualTo(-2);
    }

    @Test
    void quality_double_multiply_test() {
        QualityCalculator.doubleQualityByZeroSellIn(0);
        QualityCalculator.doubleQualityByKeywordConjured("Conjured");

        assertThat(QualityCalculator.getQuality()).isEqualTo(-4);
    }

    @Test
    void quality_plus_test() {
        if (QualityCalculator.brieCalculator("Aged Brie")){
            assertThat(QualityCalculator.getQuality()).isEqualTo(1);
        }
        if (QualityCalculator.brieCalculator("DK")){
            assertThat(QualityCalculator.getQuality()).isEqualTo(-1);
        }
    }
}
