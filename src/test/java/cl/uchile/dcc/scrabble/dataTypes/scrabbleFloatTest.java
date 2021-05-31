package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleFloatTest {
    private scrabbleFloat x;
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
        x = new scrabbleFloat(xValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void floatTest(){
        var expectedX = new scrabbleFloat(xValue);
        assertEquals(expectedX, x);
        double newX;
        do {
            newX = rng.nextDouble();
        } while (newX == xValue);
        var differentX = new scrabbleFloat(newX);
        assertNotEquals(differentX, x);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedX = new scrabbleFloat(xValue);
        var floatToString = x.toString();
        assert(floatToString instanceof String);
        assertEquals(expectedX.toString(), floatToString);
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(25)
    void toScrabStringTest(){
        var expectedFloat = new scrabbleFloat(xValue);
        var scrabString = x.toScrabString();
        assert(scrabString instanceof scrabbleString);
        assertEquals(expectedFloat.toScrabString(), scrabString);
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(25)
    void toScrabBoolTest(){
        assert(x.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(25)
    void toScrabFloatTest(){
        var expectedFloat = new scrabbleFloat(xValue);
        var scrabFloat = x.toScrabFloat();
        assert(scrabFloat instanceof scrabbleFloat);
        assertEquals(expectedFloat.toScrabFloat(), scrabFloat);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(25)
    void toScrabIntTest(){
        assert(x.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(25)
    void toScrabBinaryTest(){
        assert(x.toScrabBinary() == null);
    }

    @Test
    void sumTest(){
        var suma1 = x.sumFloat(new scrabbleFloat(2));
        scrabbleFloat expected1 = new scrabbleFloat(xValue + 2);
        assertEquals(expected1, suma1);

        var suma2 = x.sumInt(new scrabbleInt(6));
        scrabbleFloat expected2 = new scrabbleFloat(xValue + 6);
        assertEquals(expected2, suma2);

        var suma3 = x.sumBinary(new scrabbleBinary("11100010"));
        scrabbleFloat expected3 = new scrabbleFloat(xValue - 30);
        assertEquals(expected3, suma3);
    }

    @Test
    void subsTest(){
        var subs1 = x.subsFloat(new scrabbleFloat(45));
        scrabbleFloat expected1 = new scrabbleFloat(xValue - 45);
        assertEquals(expected1, subs1);

        var subs2 = x.subsInt(new scrabbleInt(16));
        scrabbleFloat expected2 = new scrabbleFloat(xValue - 16);
        assertEquals(expected2, subs2);

        var subs3 = x.subsBinary(new scrabbleBinary("11110011"));
        scrabbleFloat expected3 = new scrabbleFloat(xValue + 13);
        assertEquals(expected3, subs3);
    }

    @Test
    void multTest(){
        var mult1 = x.multFloat(new scrabbleFloat(12));
        scrabbleFloat expected1 = new scrabbleFloat(xValue * 12);
        assertEquals(expected1, mult1);

        var mult2 = x.multInt(new scrabbleInt(7));
        scrabbleFloat expected2 = new scrabbleFloat(xValue * 7);
        assertEquals(expected2, mult2);

        var mult3 = x.multBinary(new scrabbleBinary("011010010"));
        scrabbleFloat expected3 = new scrabbleFloat(xValue * 210);
        assertEquals(expected3, mult3);
    }

    @Test
    void divTest(){
        var div1 = x.divFloat(new scrabbleFloat(45));
        scrabbleFloat expected1 = new scrabbleFloat(xValue / 45);
        assertEquals(expected1, div1);

        var div2 = x.divInt(new scrabbleInt(69));
        scrabbleFloat expected2 = new scrabbleFloat(xValue / 69);
        assertEquals(expected2, div2);

        var div3 = x.divBinary(new scrabbleBinary("011011"));
        scrabbleFloat expected3 = new scrabbleFloat(xValue / 27);
        assertEquals(expected3, div3);
    }
}