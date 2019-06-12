package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;

public class ConfigJunit {

    @BeforeAll
    public static void setUpAll(TestInfo testInfo) {
        System.out.println("========== BeforeAll =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test Name class name: " + testInfo.getTestClass().getClass().getSimpleName());
    }


    @AfterAll
    public static void tearDownAll(TestInfo testInfo) {
        System.out.println("========== AfterAll =========");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("========== Test Name class name: " + testInfo.getTestClass());
    }
}
