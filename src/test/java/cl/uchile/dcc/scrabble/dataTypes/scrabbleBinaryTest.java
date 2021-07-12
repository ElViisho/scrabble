package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleBinaryTest {
    private scrabbleBinary bin;
    private String binValue;
    private int seed;
    private Random rng;
    private int strSize;
    private final int N = 100;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        binValue = "";
        seed = new Random().nextInt();
        rng = new Random(seed);
        strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin = TypeFactory.createSBinary(binValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal and two with different values are considered different
     */
    @RepeatedTest(N)
    void BinaryTest(){
        var expectedBin = TypeFactory.createSBinary(binValue);
        assertEquals(expectedBin, bin);
        assertEquals(expectedBin.hashCode(), bin.hashCode());
    }

    @RepeatedTest(N)
    void valueSetterTest(){
        String newBinValue = "";
        strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            newBinValue += Integer.toString(n);
        }
        scrabbleBinary newBin = TypeFactory.createSBinary("");
        newBin.setValue(newBinValue);
        assertEquals(TypeFactory.createSBinary(newBinValue), newBin);
    }


    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(N)
    void toStringTest(){
        var stringToString = bin.toString();
        assertEquals(bin.getValue(), stringToString);
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(N)
    void toScrabStringTest(){
        var scrabString = bin.toScrabString();
        assertEquals(TypeFactory.createSString(bin.getValue()), scrabString);
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(N)
    void toScrabBoolTest(){
        assert(bin.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(N)
    void toScrabIntTest(){
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);
        var scrabInt = bin.toScrabInt();
        assertEquals(TypeFactory.createSInt(expected), scrabInt);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(N)
    void toScrabFloatTest(){
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var expected = Integer.parseInt(value,2);
        var scrabFloat = bin.toScrabFloat();
        assertEquals(TypeFactory.createSFloat(expected), scrabFloat);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(N)
    void toScrabBinaryTest(){
        var expectedBin = TypeFactory.createSBinary(binValue);
        var scrabBin = bin.toScrabBinary();
        assertEquals(expectedBin.toScrabBinary(), scrabBin);
    }

    /**
     * Test for checking the negation method
     */
    @RepeatedTest(N)
    void negationTest(){
        String noBin = bin.getValue();
        noBin = noBin.replace('0', '2').replace('1','0').replace('2','1');
        assertEquals(TypeFactory.createSBinary(noBin), bin.negation());
    }

    /**
     * Test for checking the conjunction with other booleans and binaries
     */
    @RepeatedTest(N)
    void conjTest(){
        scrabbleBool T = TypeFactory.createSBool(true);
        scrabbleBool F = TypeFactory.createSBool(false);
        assertEquals(bin, bin.conj(T));
        assertEquals(TypeFactory.createSBinary(bin.getValue().replace('1','0')), bin.conj(F));

        String value = "";
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }

        scrabbleBinary newBin = TypeFactory.createSBinary(value);
        int x = newBin.toScrabInt().getValue();
        int y = bin.toScrabInt().getValue();
        scrabbleInt z = TypeFactory.createSInt(x & y);
        assertEquals(z.toScrabBinary(), bin.conj(newBin));
    }


    /**
     * Test for checking the disjunction with other booleans and binaries
     */
    @RepeatedTest(N)
    void disjTest(){
        scrabbleBool T = TypeFactory.createSBool(true);
        scrabbleBool F = TypeFactory.createSBool(false);
        assertEquals(bin, bin.disj(F));
        assertEquals(TypeFactory.createSBinary(bin.getValue().replace('0','1')), bin.disj(T));

        String value = "";
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            value += Integer.toString(n);
        }

        scrabbleBinary newBin = TypeFactory.createSBinary(value);
        int x = newBin.toScrabInt().getValue();
        int y = bin.toScrabInt().getValue();
        scrabbleInt z = TypeFactory.createSInt(x | y);
        assertEquals(z.toScrabBinary(), bin.disj(newBin));
    }

    /**
     * Test for checking the sums with other ints and binaries
     */
    @RepeatedTest(N)
    void sumTest(){
        int nInt = rng.nextInt();
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var binInt = Integer.parseInt(value,2);

        scrabbleInt n = TypeFactory.createSInt(nInt);
        scrabbleInt nSuma = TypeFactory.createSInt(binInt + nInt);
        assertEquals(nSuma.toScrabBinary(), bin.sum(n));

        String newvalue = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int x = rng.nextInt(2);
            newvalue += Integer.toString(x);
        }
        scrabbleBinary newbin = TypeFactory.createSBinary(newvalue);

        if (newvalue.charAt(0) == '1') {
            newvalue = newbin.twosComplement().getValue();
            newvalue = "-" + newvalue;
        }
        var newint = Integer.parseInt(newvalue,2);
        scrabbleInt nSuma2 = TypeFactory.createSInt(binInt + newint);
        assertEquals(nSuma2.toScrabBinary(), bin.sum(newbin));
    }

    /**
     * Test for checking the subtraction with other ints and binaries
     */
    @RepeatedTest(N)
    void subsTest(){
        int nInt = rng.nextInt();
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var binInt = Integer.parseInt(value,2);

        scrabbleInt n = TypeFactory.createSInt(nInt);
        scrabbleInt nSuma = TypeFactory.createSInt(binInt - nInt);
        assertEquals(nSuma.toScrabBinary(), bin.subs(n));

        String newvalue = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int x = rng.nextInt(2);
            newvalue += Integer.toString(x);
        }
        scrabbleBinary newbin = TypeFactory.createSBinary(newvalue);

        if (newvalue.charAt(0) == '1') {
            newvalue = newbin.twosComplement().getValue();
            newvalue = "-" + newvalue;
        }
        var newint = Integer.parseInt(newvalue,2);
        scrabbleInt nSuma2 = TypeFactory.createSInt(binInt - newint);
        assertEquals(nSuma2.toScrabBinary(), bin.subs(newbin));
    }

    /**
     * Test for checking the multiplication with other ints and binaries
     */
    @RepeatedTest(N)
    void multTest(){
        int nInt = rng.nextInt();
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var binInt = Integer.parseInt(value,2);

        scrabbleInt n = TypeFactory.createSInt(nInt);
        scrabbleInt nSuma = TypeFactory.createSInt(binInt * nInt);
        assertEquals(nSuma.toScrabBinary(), bin.mult(n));

        String newvalue = "";
        int strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int x = rng.nextInt(2);
            newvalue += Integer.toString(x);
        }
        scrabbleBinary newbin = TypeFactory.createSBinary(newvalue);

        if (newvalue.charAt(0) == '1') {
            newvalue = newbin.twosComplement().getValue();
            newvalue = "-" + newvalue;
        }
        var newint = Integer.parseInt(newvalue,2);
        scrabbleInt nSuma2 = TypeFactory.createSInt(binInt * newint);
        assertEquals(nSuma2.toScrabBinary(), bin.mult(newbin));
    }

    /**
     * Test for checking the division with other ints and binaries
     */
    @RepeatedTest(N)
    void divTest(){
        int nInt;
        do {
            nInt = rng.nextInt();
        } while (nInt == 0);
        String value = bin.getValue();
        if (value.charAt(0) == '1') {
            value = bin.twosComplement().getValue();
            value = "-" + value;
        }
        var binInt = Integer.parseInt(value,2);

        scrabbleInt n = TypeFactory.createSInt(nInt);
        scrabbleInt nSuma = TypeFactory.createSInt(binInt / nInt);
        assertEquals(nSuma.toScrabBinary(), bin.div(n));

        String newvalue = "";
        do {
            int strSize = rng.nextInt(20) + 1;
            for (int i=0; i<strSize; i++){
                int x = rng.nextInt(2);
                newvalue += Integer.toString(x);
            }
        } while (Integer.parseInt(newvalue,2) == 0);

        scrabbleBinary newbin = TypeFactory.createSBinary(newvalue);

        if (newvalue.charAt(0) == '1') {
            newvalue = newbin.twosComplement().getValue();
            newvalue = "-" + newvalue;
        }
        var newint = Integer.parseInt(newvalue,2);
        scrabbleInt nSuma2 = TypeFactory.createSInt(binInt / newint);
        assertEquals(nSuma2.toScrabBinary(), bin.div(newbin));
    }

}