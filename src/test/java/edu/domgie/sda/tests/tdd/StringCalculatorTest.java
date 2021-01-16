package edu.domgie.sda.tests.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void setupe() {
        stringCalculator = new StringCalculator();
    }

    // if "" passed, return 0;
    @Test
    public void testEmptyStringPassed() {
        String value = "";
        int result = stringCalculator.add(value);
        //JUNIT
        assertEquals(0, result, "Expected 0 when passing empty string");
//        ASSERTJ
//        assertThat(result).as("Expectes 0 when passing wmpty string").isEqualTo(0)
//                .isNotEqualTo(1)
//                .isGreaterThan(-3)
//                .isLessThan(2);
    }

    //if one String have one number, method have to return this number
    @Test
    public void testOneNumberPassed() {
        String toCheck = "3";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("When passing 3, expected 3 on output").isEqualTo(3);
    }

    //if more numbers passed with comma"2,3", add them  to get 5
    @Test
    public void testmoreNumbersPassed() {
        String toCheck = "2,3,2";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("Expected sum of 2 and 3").isEqualTo(7);
    }

    // is is new line handle the numbs
    @Test
    public void testHandleLinesBeetwenNumbs() {
        String toCheck = "1,\n2,3";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("Expected sum of numbs skiping lines").isEqualTo(6);
    }

    //if are diffrent delimeters
    @Test
    public void testSupportDifferentDelimiterrs() {
        String toCheck = "//;\n1;2";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("Expected 3 if we used different dilimeters").isEqualTo(3);
    }

    //if number will be negative, throw exception and was passed, if multiple negavites show all in e.message
    @Test
    public void testCallingNegativeNumber() {
//    assertThrows(NegativeNumbersException.class, () -> stringCalculator.add("-2,2,3,-5"));
        int result = 0;
        String toCheck = "-2,5,2,-5";
        try {
            result = stringCalculator.add(toCheck);
            fail("NegativeNumbersException but not thrown");
        } catch (NegativeNumbersException e) {
            assertEquals(NegativeNumbersException.class, e.getClass());
        } finally {
            assertThat(result).as("Expected 3 id we used different dilimeters").isEqualTo(0);
        }
    }

    //Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
    @Test
    public void testNumbersBiggerthan1000ignored() {
        String toCheck = "2,1001,3222233,43243242,23";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("If numbers are bigger than 1000, shoud be ignored").isEqualTo(25);
    }

    //Delimiters can be of any length with the following format
    @Test
    public void testAnyLeghtDilimeters() {
        String toCheck = "//[***]\n1***2***3";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("IF Lenght is longer tahn one char, result shoulde be correct").isEqualTo(6);
    }

    // Allow multiple delimiters
    @Test
    public void testMultipleDelimeters() {
        String toCheck = "//[*][%]\n1*2%3";
        int result = stringCalculator.add(toCheck);
        assertThat(result).as("If String have multiple delimeters, sum of numbers have to be  correct").isEqualTo(6);
    }
}