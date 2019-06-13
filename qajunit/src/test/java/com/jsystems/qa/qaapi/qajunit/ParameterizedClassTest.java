package com.jsystems.qa.qaapi.qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Parameterized tests")
public class ParameterizedClassTest extends ConfigJunit {

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.out.println("========== BeforeEach =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test Name class name: " + testInfo.getTestClass().getClass().getSimpleName()
                + " \ntest name: " + testInfo.getTestMethod() );
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("========== AfterEach =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test Name class name: " + testInfo.getTestClass()
                + " \ntest name: " + testInfo.getTestMethod() );
    }


    @DisplayName("First parameterized test")
    @ParameterizedTest(name = "Parameterized test with value {0}")
    @ValueSource(ints = {5, 15, 25})
    public void paramFirstTest(int number) {
        assertTrue(number % 5 == 0);
    }

    @DisplayName("Second parameterized test")
    @ParameterizedTest(name = "Parameterized test with value {0}")
    @ValueSource(strings = {"Hello", "Hello Junit", "Hello students"})
    public void paramSecondTest(String value) {
        assertTrue(value.contains("Hello"));
    }

    @DisplayName("Csv value parameterized test")
    @ParameterizedTest(name = "Parameterized test with values name: {0} and value: {1}")
    @CsvSource(value = {"Hello, 5", "HelloJunit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @DisplayName("Csv file source parameterized test")
    @ParameterizedTest(name = "Parameterized test with data from csv file, name: {0} and value: {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void csvFileSourceTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }


}
