package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class scrabbleStringTest {
    private scrabbleString string;
    private String str;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);
        string = new scrabbleString(str);
    }

    @RepeatedTest(20)
    void stringsTest(){
        var expectedString = new scrabbleString(str);
        assertEquals(expectedString, string);
        assertEquals(expectedString.hashCode(), string.hashCode());
        String newStr;
        do {
            newStr = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (newStr.equals(str));
        var differentString = new scrabbleString(newStr);
        assertNotEquals(differentString, string);
    }
}
