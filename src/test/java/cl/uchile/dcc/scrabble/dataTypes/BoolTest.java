package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BoolTest {
    private Bool bool;
    private boolean boolValue;
    private int seed;
    private Random rng;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random();
        boolValue = rng.nextBoolean();
        bool = new Bool(boolValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void boolTest() {
        var expectedBool = new Bool(boolValue);
        assertEquals(expectedBool, bool);
        var boolToString = bool.toString();
        assert(boolToString instanceof String);
        assertEquals(expectedBool.toString(), boolToString);
        boolean newBool;
        do {
            newBool = rng.nextBoolean();
        } while (newBool == boolValue);
        var differentBool = new Bool(newBool);
        assertNotEquals(differentBool, bool);
        assertNotEquals(differentBool.toString(), bool.toString());
    }

}