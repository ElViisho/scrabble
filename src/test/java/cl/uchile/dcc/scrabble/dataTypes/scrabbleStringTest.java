package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class scrabbleStringTest {
    private scrabbleString string;
    private String str;
    private int seed;
    private Random rng;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);
        string = new scrabbleString(str);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void stringsTest(){
        var expectedString = new scrabbleString(str);
        assertEquals(expectedString, string);
        String newStr;
        do {
            newStr = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (newStr.equals(str));
        var differentString = new scrabbleString(newStr);
        assertNotEquals(differentString, string);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedString = new scrabbleString(str);
        var stringToString = string.toString();
        assert(stringToString instanceof String);
        assertEquals(expectedString.toString(), stringToString);
    }
}
