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
    private final int N = 100;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        xValue = rng.nextDouble();
        x = TypeFactory.createSFloat(xValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(N)
    void floatTest(){
        var expectedX = TypeFactory.createSFloat(xValue);
        assertEquals(expectedX, x);
        double newX;
        do {
            newX = rng.nextDouble();
        } while (newX == xValue);
        var differentX = TypeFactory.createSFloat(newX);
        assertNotEquals(differentX, x);
    }

    @RepeatedTest(N)
    void valueSetterTest(){
        double newXValue = rng.nextDouble();
        scrabbleFloat newX = TypeFactory.createSFloat(0);
        newX.setValue(newXValue);
        assertEquals(TypeFactory.createSFloat(newXValue), newX);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(N)
    void toStringTest(){
        assertEquals(String.valueOf(xValue), x.toString());
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(N)
    void toScrabStringTest(){
        var expected = TypeFactory.createSString(String.valueOf(xValue));
        assertEquals(expected, x.toScrabString());
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(N)
    void toScrabBoolTest(){
        assert(x.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(N)
    void toScrabFloatTest(){
        assertEquals(x, x.toScrabFloat());
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(N)
    void toScrabIntTest(){
        assert(x.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(N)
    void toScrabBinaryTest(){
        assert(x.toScrabBinary() == null);
    }

    /**
     * Test for checking the sums with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void sumTest(){
        int nInt = rng.nextInt();
        var a = x.sum(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSFloat(xValue + nInt), a);

        double nDouble = rng.nextDouble();
        var b = x.sum(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(xValue + nDouble), b);

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }
        scrabbleBinary bin = TypeFactory.createSBinary(value);

        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);

        assertEquals(TypeFactory.createSFloat(xValue + expected), x.sum(bin));
    }

    /**
     * Test for checking the subtraction with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void subsTest(){
        int nInt = rng.nextInt();
        var a = x.subs(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSFloat(xValue - nInt), a);

        double nDouble = rng.nextDouble();
        var b = x.subs(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(xValue - nDouble), b);

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }
        scrabbleBinary bin = TypeFactory.createSBinary(value);

        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);

        assertEquals(TypeFactory.createSFloat(xValue - expected), x.subs(bin));
    }

    /**
     * Test for checking the multiplication with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void multTest(){
        int nInt = rng.nextInt();
        var a = x.mult(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSFloat(xValue * nInt), a);

        double nDouble = rng.nextDouble();
        var b = x.mult(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(xValue * nDouble), b);

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }
        scrabbleBinary bin = TypeFactory.createSBinary(value);

        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);

        assertEquals(TypeFactory.createSFloat(xValue * expected), x.mult(bin));
    }

    /**
     * Test for checking the division with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void divTest(){
        int nInt;
        do {
            nInt = rng.nextInt();
        } while (nInt == 0);
        var a = x.div(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSFloat(xValue / nInt), a);

        double nDouble;
        do {
            nDouble = rng.nextDouble();
        } while (nDouble == 0);
        var b = x.div(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(xValue / nDouble), b);

        String value = "";
        int strSize = rng.nextInt(20) + 1;
        do {
            for (int i = 0; i < strSize; i++) {
                int n = rng.nextInt(2);
                value += Integer.toString(n);
            }
        } while (Integer.parseInt(value,2) == 0);
        scrabbleBinary bin = TypeFactory.createSBinary(value);

        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);

        assertEquals(TypeFactory.createSFloat(xValue / expected), x.div(bin));
    }
}