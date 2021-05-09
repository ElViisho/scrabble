package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BinaryTest {
    private Binary bin;
    private String binValue;
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
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(1);
            binValue += Integer.toString(n);
        }
        bin = new Binary(binValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void stringsTest(){
        var expectedBin = new Binary(binValue);
        assertEquals(expectedBin, bin);
        var stringToString = bin.toString();
        assert(stringToString instanceof String);
        assertEquals(expectedBin.toString(), stringToString);
        String newBin;
        do {
            newBin = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (newBin.equals(binValue));
        var differentBin = new Binary(newBin);
        assertNotEquals(differentBin, bin);
    }
}