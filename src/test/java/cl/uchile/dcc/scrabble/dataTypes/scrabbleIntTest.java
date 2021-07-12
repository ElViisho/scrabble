package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleIntTest {
    private scrabbleInt n;
    private int nValue;
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
        nValue = rng.nextInt();
        n = TypeFactory.createSInt(nValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(N)
    void IntTest(){
        var expectedN = TypeFactory.createSInt(nValue);
        assertEquals(expectedN, n);
        int newN;
        do {
            newN = rng.nextInt();
        } while (newN == nValue);
        var differentN = TypeFactory.createSInt(newN);
        assertNotEquals(differentN, n);
    }

    @RepeatedTest(N)
    void valueSetterTest(){
        int newNValue = rng.nextInt();
        scrabbleInt newN = TypeFactory.createSInt(0);
        newN.setValue(newNValue);
        assertEquals(TypeFactory.createSInt(newNValue), newN);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(N)
    void toStringTest(){
        assertEquals(String.valueOf(nValue), n.toString());
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(N)
    void toScrabStringTest(){
        var expected = TypeFactory.createSString(String.valueOf(nValue));
        assertEquals(expected, n.toScrabString());
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(N)
    void toScrabBoolTest(){
        assert(n.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(N)
    void toScrabFloatTest(){
        var expected = TypeFactory.createSFloat(nValue);
        assertEquals(expected, n.toScrabFloat());
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(N)
    void toScrabIntTest(){
        assertEquals(n, n.toScrabInt());
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(N)
    void toScrabBinaryTest(){
        String s = Integer.toBinaryString(nValue);
        if (nValue > 0) s = '0' + s;
        scrabbleBinary expectedBin = TypeFactory.createSBinary(s);
        assertEquals(expectedBin, n.toScrabBinary());
    }

    /**
     * Test for checking the sums with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void sumTest(){
        int nInt = rng.nextInt();
        var a = n.sum(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSInt(nValue + nInt), a);

        double nDouble = rng.nextDouble();
        var b = n.sum(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(nValue + nDouble), b);

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

        assertEquals(TypeFactory.createSInt(nValue + expected), n.sum(bin));
    }

    /**
     * Test for checking the subtraction with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void subsTest(){
        int nInt = rng.nextInt();
        var a = n.subs(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSInt(nValue - nInt), a);

        double nDouble = rng.nextDouble();
        var b = n.subs(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(nValue - nDouble), b);

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

        assertEquals(TypeFactory.createSInt(nValue - expected), n.subs(bin));
    }

    /**
     * Test for checking the multiplication with other ints, floats and binaries
     */
    @RepeatedTest(N)
    void multTest(){
        int nInt = rng.nextInt();
        var a = n.mult(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSInt(nValue * nInt), a);

        double nDouble = rng.nextDouble();
        var b = n.mult(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(nValue * nDouble), b);

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

        assertEquals(TypeFactory.createSInt(nValue * expected), n.mult(bin));
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
        var a = n.div(TypeFactory.createSInt(nInt));
        assertEquals(TypeFactory.createSInt(nValue / nInt), a);

        double nDouble;
        do {
            nDouble = rng.nextDouble();
        } while (nDouble == 0);
        var b = n.div(TypeFactory.createSFloat(nDouble));
        assertEquals(TypeFactory.createSFloat(nValue / nDouble), b);

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

        assertEquals(TypeFactory.createSInt(nValue / expected), n.div(bin));
    }

}