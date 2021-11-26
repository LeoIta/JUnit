package com.leoita.fitApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BMICalculatorTest {

    @Test
    void shouldReturnTrueWhenDietRecommended() {

        //given
        double weight = 78.0;
        double height = 1.75;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }

    @Test
    void shouldReturnFalseWhenDietNotRecommended() {

        //given
        double weight = 72.0;
        double height = 1.75;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(isDietRecommended);
    }
}
