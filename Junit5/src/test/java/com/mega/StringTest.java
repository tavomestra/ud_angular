/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mega;

import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Gustavo Adolfo Mestra Garay <tavomestra22@gmail.com>
 */
public class StringTest {

    private String str;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialize connection to db");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("close connection to db");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Inicializa test data for each test " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up test data " + info.getDisplayName());
    }

    @Test
    @Disabled
    void test1() {
        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    @DisplayName("Cuando length is null, lanza una excepcion")
    void length_exception() {
        String str = null;

        assertThrows(NullPointerException.class,
                () -> {
                    str.length();
                }
        );
    }

    @Test
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5),
                () -> {
                    for (int i = 0; i <= 1000; i++) {
                        int j = i;
                        System.out.println(j);
                    }
                });
    }

    @Test
    void lengthGreaterThanZero() {
        assertTrue("ABCD".length() > 0);
        assertTrue("ABC".length() > 0);
        assertTrue("A".length() > 0);
        assertTrue("DEF".length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC", "ABC", "A", "DEF"})
    void lengthGreaterThanZeroParameterezid(String str) {
        assertTrue(str.length() > 0);

    }

    @ParameterizedTest(name = "{0} toUpperCase is {1}")
    @CsvSource(value = {"abcd, ABCD", "'',''", "abc, ABC"})
    void upperCase(String word, String capitalizedWord) {
        assertEquals(capitalizedWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abcd, 4", "'',0", "abc, 3"})
    void length(String word, int lengthExpected) {
        assertEquals(lengthExpected, word.length());
    }

    @Test
    void toUpperCase_basic() {
        String str = "abcd";
        String resutl = str.toUpperCase();
        assertNotNull(resutl);
        assertEquals("ABCD", resutl);
    }

    @Test
    @RepeatedTest(10)
    void contains_basic() {
        assertFalse("abcedfgh".contains("ijk"));
    }

    @Test
    void split_basic() {
        String str = "abc def ghi";
        String actualResult[] = str.split(" ");
        String[] expectedResult = new String[]{"abc", "def", "ghi"};
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Nested
    class EmptyStringTests {

        @BeforeEach
        void setToEmpty() {
            str = "";
        }
        
        @Test
        void lengthIsZero(){
            assertEquals(0, str.length());
        }
        
        @Test
        void upperCaseIsEmpty(){
            assertEquals("", str.toUpperCase());
        }
        
        

    }

}
