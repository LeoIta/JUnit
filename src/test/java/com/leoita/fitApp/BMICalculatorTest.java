package com.leoita.fitApp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting all the tests ...\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All unit tests executed");
    }

    @BeforeEach
    void setup() {
        System.out.print("unit test is starting ...");
    }

    @AfterEach
    void tearDown() {
        System.out.println(" unit test was executed\n");
    }

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
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void shouldReturnCoderWithWorstBMIWhenCoderListNotEmpty() {

        //given
        List<Coder> coders = Arrays.asList(
                new Coder(1.80, 60.0),
                new Coder(1.82, 98.0),
                new Coder(1.82, 64.7)
        );

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then

        assertAll(
                () -> assertEquals(1.82, coderWorstBMI.getHeight()),
                () -> assertEquals(98.0, coderWorstBMI.getWeight())
        );
        /*assertAll will execute all the tests even if one of them fails
        without it if we have multiple assertions and the first fails we'll not have any info about other tests*/
    }

    @Test
    void shouldReturnNullWhenCoderListEmpty() {

        //given
        List<Coder> coders = new ArrayList<>();

        //when
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //then

        assertNull(coderWorstBMI);
    }

    @Test
    void shouldReturnCorrectBMIScoreArrayWhenCoderListNotEmpty() {

        //given
        List<Coder> coders = Arrays.asList(
                new Coder(1.80, 60.0),
                new Coder(1.82, 98.0),
                new Coder(1.82, 64.7)
        );
        double[] expected = {18.52, 29.59, 19.53};

        //when

        double[] bmiScores = BMICalculator.getBMIScores(coders);

        //then
        assertArrayEquals(expected, bmiScores);
    }

    @ParameterizedTest
    @ValueSource(doubles = {78.0, 85.0, 89.0, 99.0})
    void shouldReturnTrueWhenDietRecommendedMultipleInput(Double userWeight) {

        //given
        double weight = userWeight;
        double height = 1.75;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }

    @ParameterizedTest
    @CsvSource(value = {"78.0,1.72", "95.0,1.75", "110.0,1.78"})
    void shouldReturnTrueWhenDietRecommendedMultipleInput(Double userWeight, Double userHeight) {

        //given
        double weight = userWeight;
        double height = userHeight;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }

    @ParameterizedTest(name = "weight={0},height={1}")
    @CsvSource(value = {"78.0,1.72", "95.0,1.75", "110.0,1.78"})
    void shouldReturnTrueWhenDietRecommendedMultipleInputWithHeader(Double userWeight, Double userHeight) {

        //given
        double weight = userWeight;
        double height = userHeight;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }

    @ParameterizedTest(name = "weight={0},height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
    void shouldReturnTrueWhenDietRecommendedMultipleInputFromExternalCSV(Double userWeight, Double userHeight) {

        //given
        double weight = userWeight;
        double height = userHeight;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }
}
