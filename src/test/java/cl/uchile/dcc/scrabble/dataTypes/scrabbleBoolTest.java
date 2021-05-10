package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleBoolTest {
    private scrabbleBool bool;
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
        bool = new scrabbleBool(boolValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void boolTest() {
        var expectedBool = new scrabbleBool(boolValue);
        assertEquals(expectedBool, bool);
        boolean newBool;
        do {
            newBool = rng.nextBoolean();
        } while (newBool == boolValue);
        var differentBool = new scrabbleBool(newBool);
        assertNotEquals(differentBool, bool);
        assertNotEquals(differentBool.toString(), bool.toString());
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedBool = new scrabbleBool(boolValue);
        var boolToString = bool.toString();
        assert(boolToString instanceof String);
        assertEquals(expectedBool.toString(), boolToString);
    }

}