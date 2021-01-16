package edu.domgie.sda.tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Utils utils;

    @BeforeAll//uzywany rzadzie, raczej testy integracyje
    public static void commonSetupe() {
        System.out.println("CommonSetupe called once per clas");
    }

    @BeforeEach//uzywany czesciej
    public void setup() {
        System.out.println("Set new object for very test");
        utils = new Utils();
    }

    @Test
    public void testRemovePairs() {
        String expected = "ABCDEFG";
        String toCheck = "AABCCDEFFG";

        String result = utils.removePairs(toCheck);

        assertEquals(expected, result);
    }
    @Test
    public void testEveryNthChar(){
        char[] expected = new char[] {'b','d','f'};
        char[] toCheck = new char[] {'a','b','c','d','e','f'};

        char[] result = utils.everyNthChar(toCheck,2);

        assertArrayEquals(expected,result,"Zle kolego");
    }

    @AfterEach
    public void teardoown() {
        System.out.println("After each test");
        utils.toString();
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("AfterAll run once after all tests");
    }

}