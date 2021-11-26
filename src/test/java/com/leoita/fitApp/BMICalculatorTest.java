package com.leoita.fitApp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void shouldThrowArithmeticExceptionWhenHeightZero() {

        //given
        double weight = 50.0;
        double height = 0.00;

        //when
        Executable executable = ()-> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class,executable);
    }
}
