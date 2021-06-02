package cl.uchile.dcc.scrabble.dataTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class scrabbleStringTest {
    private scrabbleString string;
    private String str;
    private int seed;
    private Random rng;
    private final int N = 100;

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
        str = randomAlphanumeric(strSize);
        string = new scrabbleString(str);

        //Sum
        strSize = rng.nextInt(20);
        newStr = randomAlphanumeric(strSize);
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
    @RepeatedTest(N)
    void stringsTest(){
        var expectedString = new scrabbleString(str);
        assertEquals(expectedString, string);
        int strSize = rng.nextInt(20) + 1;
        String newStr;
        do {
            newStr = randomAlphanumeric(strSize);
        } while (newStr.equals(str));
        var differentString = new scrabbleString(newStr);
        assertNotEquals(differentString, string);
    }

    @RepeatedTest(N)
    void valueSetterTest(){
        int strSize = rng.nextInt(20) + 1;
        String newstr = randomAlphanumeric(strSize);
        scrabbleString newString = new scrabbleString("");
        newString.setValue(newstr);
        assertEquals(new scrabbleString(newstr), newString);
    }

    /**
     * Test for checking the toString() method
     */
    @RepeatedTest(N)
    void toStringTest(){
        assertEquals(str, string.toString());
    }

    /**
     * Test for checking the toScrabString() method
     */
    @RepeatedTest(N)
    void toScrabStringTest(){
        assertEquals(string, string.toScrabString());
    }

    /**
     * Test for checking the toScrabBool() method
     */
    @RepeatedTest(N)
    void toScrabBoolTest(){
        assert(string.toScrabBool() == null);
    }

    /**
     * Test for checking the toScrabFloat() method
     */
    @RepeatedTest(N)
    void toScrabFloatTest(){
        assert(string.toScrabFloat() == null);
    }

    /**
     * Test for checking the toScrabInt() method
     */
    @RepeatedTest(N)
    void toScrabIntTest(){
        assert(string.toScrabInt() == null);
    }

    /**
     * Test for checking the toScrabBinary() method
     */
    @RepeatedTest(N)
    void toScrabBinaryTest(){
        assert(string.toScrabBinary() == null);
    }


    /**
     * Test for checking all the sums with the other types
     */
    @RepeatedTest(N)
    void sumTest() {
        var sumString = string.sum(newString);
        scrabbleString expectedStr = new scrabbleString(string.getValue() + newStr);
        assertEquals(expectedStr, sumString);

        var sumBool = string.sum(newBoolean);
        scrabbleString expectedBool = new scrabbleString(string.toString() + newBoolean.getValue());
        assertEquals(expectedBool, sumBool);

        var sumFloat = string.sum(newFloat);
        scrabbleString expectedFloat = new scrabbleString(string.toString() + newFloat.getValue());
        assertEquals(expectedFloat, sumFloat);

        var sumInt = string.sum(newInt);
        scrabbleString expectedInt = new scrabbleString(string.toString() + newInt.getValue());
        assertEquals(expectedInt, sumInt);

        var sumBin = string.sum(newBinary);
        scrabbleString expectedBin = new scrabbleString(string.toString() + newBinary.getValue());
        assertEquals(expectedBin, sumBin);
    }
}
