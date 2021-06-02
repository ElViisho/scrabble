package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleBoolTest {
    private scrabbleBool bool;
    private boolean boolValue;
    private int seed;
    private Random rng;
    private final int N = 25;

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

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(25)
    void toScrabStringTest(){
        var expectedBool = new scrabbleBool(boolValue);
        var scrabString = bool.toScrabString();
        assert(scrabString instanceof scrabbleString);
        assertEquals(expectedBool.toScrabString(), scrabString);
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(25)
    void toScrabBoolTest(){
        var expectedBool = new scrabbleBool(boolValue);
        var scrabBool = bool.toScrabBool();
        assert(scrabBool instanceof scrabbleBool);
        assertEquals(expectedBool.toScrabBool(), scrabBool);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(25)
    void toScrabFloatTest(){
        assert(bool.toScrabFloat() == null);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(25)
    void toScrabIntTest(){
        assert(bool.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(25)
    void toScrabBinaryTest(){
        assert(bool.toScrabBinary() == null);
    }

    /**
     * Test for checking the conjunction between booleans
     */
    @Test
    void conjTest(){
        scrabbleBool T = new scrabbleBool(true);
        scrabbleBool F = new scrabbleBool(false);

        assertTrue(T.conj(new scrabbleBool(true)).toScrabBool().getValue());
        assertFalse(F.conj(new scrabbleBool(true)).toScrabBool().getValue());
        assertFalse(T.conj(new scrabbleBool(false)).toScrabBool().getValue());
        assertFalse(F.conj(new scrabbleBool(false)).toScrabBool().getValue());

        scrabbleBinary bin = new scrabbleBinary("10001001");
        scrabbleBinary expected = new scrabbleBinary("00000000");
        assertEquals(bin, bin.conj(T));
        assertEquals(expected, bin.conj(F));
    }

    /**
     * Test for checking the disjunction between booleans
     */
    @Test
    void disjTest(){
        scrabbleBool T = new scrabbleBool(true);
        scrabbleBool F = new scrabbleBool(false);

        assertTrue(T.disj(new scrabbleBool(true)).toScrabBool().getValue());
        assertTrue(F.disj(new scrabbleBool(true)).toScrabBool().getValue());
        assertTrue(T.disj(new scrabbleBool(false)).toScrabBool().getValue());
        assertFalse(F.disj(new scrabbleBool(false)).toScrabBool().getValue());

        scrabbleBinary bin = new scrabbleBinary("10001001");
        scrabbleBinary expected = new scrabbleBinary("11111111");
        assertEquals(bin, bin.disj(F));
        assertEquals(expected, bin.disj(T));
    }

}