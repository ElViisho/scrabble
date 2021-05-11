package cl.uchile.dcc.scrabble.dataTypes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class scrabbleBinaryTest {
    private scrabbleBinary bin;
    private String binValue;
    private int seed;
    private Random rng;
    private int strSize;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(1);
            binValue += Integer.toString(n);
        }
        bin = new scrabbleBinary(binValue);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal and two with different values are considered different
     */
    @RepeatedTest(25)
    void BinaryTest(){
        var expectedBin = new scrabbleBinary(binValue);
        assertEquals(expectedBin, bin);
        assertEquals(expectedBin.hashCode(), bin.hashCode());
        String newBin = "";
        do {
            for (int i=0; i<strSize; i++){
                int n = rng.nextInt(1);
                newBin += Integer.toString(n);
            }
        } while (newBin.equals(binValue));
        var differentBin = new scrabbleBinary(newBin);
        assertNotEquals(differentBin, bin);
    }


    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedBin = new scrabbleBinary(binValue);
        var stringToString = bin.toString();
        assert(stringToString instanceof String);
        assertEquals(expectedBin.toString(), stringToString);
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(25)
    void toScrabStringTest(){
        var expectedBin = new scrabbleBinary(binValue);
        var scrabString = bin.toScrabString();
        assert(scrabString instanceof scrabbleString);
        assertEquals(expectedBin.toScrabString(), scrabString);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(25)
    void toScrabBinaryTest(){
        var expectedBin = new scrabbleBinary(binValue);
        var scrabBin = bin.toScrabBinary();
        assert(scrabBin instanceof scrabbleBinary);
        assertEquals(expectedBin.toScrabBinary(), scrabBin);
    }

}