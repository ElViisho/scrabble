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
        assert(n.toScrabBinary() == null);
    }


    @Test
    void sumTest(){
        var suma1 = n.sumFloat(new scrabbleFloat(298.0));
        scrabbleFloat expected1 = new scrabbleFloat(nValue + 298.0);
        assertEquals(expected1, suma1);

        var suma2 = n.sumInt(new scrabbleInt(54));
        scrabbleInt expected2 = new scrabbleInt(nValue + 54);
        assertEquals(expected2, suma2);

        var suma3 = n.sumBinary(new scrabbleBinary("110111101"));
        scrabbleInt expected3 = new scrabbleInt(nValue + 445);
        assertEquals(expected3, suma3);
    }

    @Test
    void subsTest(){
        var subs1 = n.subsFloat(new scrabbleFloat(4565.0));
        scrabbleFloat expected1 = new scrabbleFloat(nValue - 4565.0);
        assertEquals(expected1, subs1);

        var subs2 = n.subsInt(new scrabbleInt(23));
        scrabbleInt expected2 = new scrabbleInt(nValue - 23);
        assertEquals(expected2, subs2);

        var subs3 = n.subsBinary(new scrabbleBinary("110111"));
        scrabbleInt expected3 = new scrabbleInt(nValue - 55);
        assertEquals(expected3, subs3);
    }

    @Test
    void multTest(){
        var mult1 = n.multFloat(new scrabbleFloat(21.0));
        scrabbleFloat expected1 = new scrabbleFloat(nValue * 21.0);
        assertEquals(expected1, mult1);

        var mult2 = n.multInt(new scrabbleInt(798));
        scrabbleInt expected2 = new scrabbleInt(nValue * 798);
        assertEquals(expected2, mult2);

        var mult3 = n.multBinary(new scrabbleBinary("1101111"));
        scrabbleInt expected3 = new scrabbleInt(nValue * 111);
        assertEquals(expected3, mult3);
    }

    @Test
    void divTest(){
        var div1 = n.divFloat(new scrabbleFloat(97.0));
        scrabbleFloat expected1 = new scrabbleFloat(nValue / 97.0);
        assertEquals(expected1, div1);

        var div2 = n.divInt(new scrabbleInt(8400021));
        scrabbleInt expected2 = new scrabbleInt(nValue / 8400021);
        assertEquals(expected2, div2);

        var div3 = n.divBinary(new scrabbleBinary("1001"));
        scrabbleInt expected3 = new scrabbleInt(nValue / 9);
        assertEquals(expected3, div3);
    }
}