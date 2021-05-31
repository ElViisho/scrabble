package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class scrabbleStringTest {
    private scrabbleString string;
    private String str;
    private int seed;
    private Random rng;

    private String newStr;
    private scrabbleString newString;

    private boolean newBool;
    private scrabbleBool newBoolean;

    private double newX;
    private scrabbleFloat newFloat;

    private int newN;
    private scrabbleInt newInt;

    private String newBin;
    private scrabbleBinary newBinary;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, false, null, rng);
        string = new scrabbleString(str);

        //Sum
        newStr = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        newString = new scrabbleString(newStr);

        newBool = rng.nextBoolean();
        newBoolean = new scrabbleBool(newBool);

        newX = rng.nextDouble();
        newFloat = new scrabbleFloat(newX);

        newN = rng.nextInt();
        newInt = new scrabbleInt(newN);

        newBin = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        newBinary = new scrabbleBinary(newBin);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(25)
    void stringsTest(){
        var expectedString = new scrabbleString(str);
        assertEquals(expectedString, string);
        String newStr;
        do {
            newStr = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        } while (newStr.equals(str));
        var differentString = new scrabbleString(newStr);
        assertNotEquals(differentString, string);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(25)
    void toStringTest(){
        var expectedString = new scrabbleString(str);
        var stringToString = string.toString();
        assert(stringToString instanceof String);
        assertEquals(expectedString.toString(), stringToString);
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(25)
    void toScrabStringTest(){
        var expectedString = new scrabbleString(str);
        var scrabString = string.toScrabString();
        assert(scrabString instanceof scrabbleString);
        assertEquals(expectedString.toScrabString(), scrabString);
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(25)
    void toScrabBoolTest(){
        assert(string.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(25)
    void toScrabFloatTest(){
        assert(string.toScrabFloat() == null);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(25)
    void toScrabIntTest(){
        assert(string.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(25)
    void toScrabBinaryTest(){
        assert(string.toScrabBinary() == null);
    }


    /**
     * Test for checking all the sums with the other types
     */
    @RepeatedTest(25)
    void sumTest() {
        var sumString = string.sumString(newString);
        scrabbleString expectedStr = new scrabbleString(string.toString() + newStr);
        assertEquals(expectedStr, sumString);

        var sumBool = string.sumBool(newBoolean);
        scrabbleString expectedBool = new scrabbleString(string.toString() + newBoolean.toString());
        assertEquals(expectedBool, sumBool);

        var sumFloat = string.sumFloat(newFloat);
        scrabbleString expectedFloat = new scrabbleString(string.toString() + newFloat.toString());
        assertEquals(expectedFloat, sumFloat);

        var sumInt = string.sumInt(newInt);
        scrabbleString expectedInt = new scrabbleString(string.toString() + newInt.toString());
        assertEquals(expectedInt, sumInt);

        var sumBin = string.sumBinary(newBinary);
        scrabbleString expectedBin = new scrabbleString(string.toString() + newBinary.toString());
        assertEquals(expectedBin, sumBin);
    }
}
