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
        string = TypeFactory.createSString(str);

        //Sum
        strSize = rng.nextInt(20);
        newStr = randomAlphanumeric(strSize);
        newString = TypeFactory.createSString(newStr);

        newBool = rng.nextBoolean();
        newBoolean = TypeFactory.createSBool(newBool);

        newX = rng.nextDouble();
        newFloat = TypeFactory.createSFloat(newX);

        newN = rng.nextInt();
        newInt = TypeFactory.createSInt(newN);

        newBin = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, false, null, rng);
        newBinary = TypeFactory.createSBinary(newBin);
    }

    /**
     * The different tests that check that two instances that have the same value
     * are considered equal, two with different values are considered different,
     * and also checks the toString method
     */
    @RepeatedTest(N)
    void stringsTest(){
        var expectedString = TypeFactory.createSString(str);
        assertEquals(expectedString, string);
        int strSize = rng.nextInt(20) + 1;
        String newStr;
        do {
            newStr = randomAlphanumeric(strSize);
        } while (newStr.equals(str));
        var differentString = TypeFactory.createSString(newStr);
        assertNotEquals(differentString, string);
    }

    @RepeatedTest(N)
    void valueSetterTest(){
        int strSize = rng.nextInt(20) + 1;
        String newstr = randomAlphanumeric(strSize);
        scrabbleString newString = TypeFactory.createSString("");
        newString.setValue(newstr);
        assertEquals(TypeFactory.createSString(newstr), newString);
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
        var sumString = string.concatenate(newString);
        scrabbleString expectedStr = TypeFactory.createSString(string.getValue() + newStr);
        assertEquals(expectedStr, sumString);

        var sumBool = string.concatenate(newBoolean);
        scrabbleString expectedBool = TypeFactory.createSString(string.toString() + newBoolean.getValue());
        assertEquals(expectedBool, sumBool);

        var sumFloat = string.concatenate(newFloat);
        scrabbleString expectedFloat = TypeFactory.createSString(string.toString() + newFloat.getValue());
        assertEquals(expectedFloat, sumFloat);

        var sumInt = string.concatenate(newInt);
        scrabbleString expectedInt = TypeFactory.createSString(string.toString() + newInt.getValue());
        assertEquals(expectedInt, sumInt);

        var sumBin = string.concatenate(newBinary);
        scrabbleString expectedBin = TypeFactory.createSString(string.toString() + newBinary.getValue());
        assertEquals(expectedBin, sumBin);
    }
}
