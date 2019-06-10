package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Junit tests")
public class JunitTest {

        final String stringTestowy = "stringTestowyt";
        final String testowy = null;

    @Test
    @DisplayName("First junit test")
    @Disabled("It's wait for bug fixing")
    public void firstTest() {

        assertTrue(true, "message for test result");
        assertTrue(stringTestowy.equals("stringTestowyt"), "message for test result");
        assertTrue(5 == 2 + 3, "message for test result");
        assertTrue(true);
        assertFalse(false);
        assertFalse(stringTestowy.matches("^s"));
        assertEquals("stringTestowyt", stringTestowy);
//        assertNotNull(testowy);
        assertSame("stringTestowyt", stringTestowy);
//        assertThat();


    }

    @Test
    @DisplayName("Second junit test")
    @Tag("All")
    @RepeatedTest(value = 5, name ="Repeated test")
    public void secondTest() {
        assertThat(stringTestowy).isEqualTo("stringTestowyt");
        System.out.println(0.2 * 0.2 );
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
        assertFalse(0.2 * 0.2 == 0.04);
    }

    @Test
    @DisplayName("Array test")
    public void arrayTest() {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);

        assertTrue(list1.containsAll(list2));
        assertThat(list1).hasSize(5);
        assertThat(list2).containsAnyOf(1,2,3,4,5,6,7,8);

    }

    @Test
    @DisplayName("Testowy")
    public void testowy(){

    }

    @Nested
    @DisplayName("Nested Test class")
    public class nestedSuiteClassTest {

        final String stringTestowy = "stringTestowyt";

        @Test
        @DisplayName("Nested class test")
        public void nestedTest() {
            assertThat(stringTestowy).isEqualTo("stringTestowyt");
        }
    }


}
