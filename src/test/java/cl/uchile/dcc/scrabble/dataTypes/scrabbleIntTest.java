package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleIntTest {
    private scrabbleInt n;
    private int nValue;
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
        nValue = rng.nextInt();
        n = new scrabbleInt(nValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void IntTest(){
        var expectedN = new scrabbleInt(nValue);
        assertEquals(expectedN, n);
        int newN;
        do {
            newN = rng.nextInt();
        } while (newN == nValue);
        var differentN = new scrabbleInt(newN);
        assertNotEquals(differentN, n);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedN = new scrabbleInt(nValue);
        var intToString = n.toString();
        assert(intToString instanceof String);
        assertEquals(expectedN.toString(), intToString);
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(25)
    void toScrabStringTest(){
        var expectedInt = new scrabbleInt(nValue);
        var scrabString = n.toScrabString();
        assert(scrabString instanceof scrabbleString);
        assertEquals(expectedInt.toScrabString(), scrabString);
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(25)
    void toScrabBoolTest(){
        assert(n.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(25)
    void toScrabFloatTest(){
        var expectedInt = new scrabbleInt(nValue);
        var scrabFloat = n.toScrabFloat();
        assert(scrabFloat instanceof scrabbleFloat);
        assertEquals(expectedInt.toScrabFloat(), scrabFloat);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(25)
    void toScrabIntTest(){
        System.out.println(nValue);
        var expectedInt = new scrabbleInt(nValue);
        var scrabInt = n.toScrabInt();
        assert(scrabInt instanceof scrabbleInt);
        assertEquals(expectedInt.toScrabInt(), scrabInt);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(25)
    void toScrabBinaryTest(){
        scrabbleBinary expectedBin = new scrabbleBinary(Integer.toBinaryString(nValue));
        assertEquals(expectedBin, n.toScrabBinary());
    }

    @Test
    void sumTest(){
        scrabbleInt x = new scrabbleInt(8);
        var a = x.div(new scrabbleInt(2));
        System.out.println(a);
        var b = x.div(new scrabbleFloat(7));
        System.out.println(b);
        var c = x.div(new scrabbleBinary("1001"));
        System.out.println(c);
    }

}