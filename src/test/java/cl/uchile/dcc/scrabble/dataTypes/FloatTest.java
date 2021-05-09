package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FloatTest {
    private Float x;
    private double xValue;
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
        xValue = rng.nextDouble();
        x = new Float(xValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void stringsTest(){
        var expectedX = new Float(xValue);
        assertEquals(expectedX, x);
        var stringToString = x.toString();
        assert(stringToString instanceof String);
        assertEquals(expectedX.toString(), stringToString);
        double newX;
        do {
            newX = rng.nextDouble();
        } while (newX == xValue);
        var differentX = new Float(newX);
        assertNotEquals(differentX, x);
    }
}