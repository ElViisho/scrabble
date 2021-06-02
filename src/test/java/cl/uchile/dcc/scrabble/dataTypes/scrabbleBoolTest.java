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
    private final int N = 100;

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
    @RepeatedTest(N)
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

    @RepeatedTest(N)
    void valueSetterTest(){
        boolean newBoolValue = rng.nextBoolean();
        scrabbleBool newBool = new scrabbleBool(false);
        newBool.setValue(newBoolValue);
        assertEquals(new scrabbleBool(newBoolValue), newBool);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(N)
    void toStringTest(){
        assertEquals(String.valueOf(boolValue), bool.toString());
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(N)
    void toScrabStringTest(){
        var expected = new scrabbleString(String.valueOf(boolValue));
        assertEquals(expected, bool.toScrabString());
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(N)
    void toScrabBoolTest(){
        assertEquals(bool, bool.toScrabBool());
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(N)
    void toScrabFloatTest(){
        assert(bool.toScrabFloat() == null);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(N)
    void toScrabIntTest(){
        assert(bool.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(N)
    void toScrabBinaryTest(){
        assert(bool.toScrabBinary() == null);
    }

    @Test
    void negationTest(){
        assertFalse((new scrabbleBool(true)).negation().getValue());
        assertTrue((new scrabbleBool(false)).negation().getValue());
    }

    /**
     * Test for checking the conjunction between booleans
     */
    @RepeatedTest(N)
    void conjTest(){
        scrabbleBool T = new scrabbleBool(true);
        scrabbleBool F = new scrabbleBool(false);

        assertTrue(T.conj(new scrabbleBool(true)).toScrabBool().getValue());
        assertFalse(F.conj(new scrabbleBool(true)).toScrabBool().getValue());
        assertFalse(T.conj(new scrabbleBool(false)).toScrabBool().getValue());
        assertFalse(F.conj(new scrabbleBool(false)).toScrabBool().getValue());

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }
        scrabbleBinary bin = new scrabbleBinary(value);
        String otherValue = "";
        for (int i=0; i<strSize; i++){
            otherValue += '0';
        }
        scrabbleBinary expected = new scrabbleBinary(otherValue);

        assertEquals(bin, T.conj(bin));
        assertEquals(expected, F.conj(bin));
    }

    /**
     * Test for checking the disjunction between booleans
     */
    @RepeatedTest(N)
    void disjTest(){
        scrabbleBool T = new scrabbleBool(true);
        scrabbleBool F = new scrabbleBool(false);

        assertTrue(T.disj(new scrabbleBool(true)).toScrabBool().getValue());
        assertTrue(F.disj(new scrabbleBool(true)).toScrabBool().getValue());
        assertTrue(T.disj(new scrabbleBool(false)).toScrabBool().getValue());
        assertFalse(F.disj(new scrabbleBool(false)).toScrabBool().getValue());

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }
        scrabbleBinary bin = new scrabbleBinary(value);
        String otherValue = "";
        for (int i=0; i<strSize; i++){
            otherValue += '1';
        }
        scrabbleBinary expected = new scrabbleBinary(otherValue);

        assertEquals(bin, F.disj(bin));
        assertEquals(expected, T.disj(bin));
    }

}