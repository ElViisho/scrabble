package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BasicLogicTest {
    private scrabbleBool bool;
    private scrabbleBool bool2;
    private boolean boolValue;

    private scrabbleBinary bin;
    private scrabbleBinary bin2;
    private String binValue;
    private int strSize;

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
        rng = new Random();
        boolValue = rng.nextBoolean();
        bool = TypeFactory.createSBool(boolValue);
        boolValue = rng.nextBoolean();
        bool2 = TypeFactory.createSBool(boolValue);

        binValue = "";
        strSize = rng.nextInt(20) + 1;
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin = TypeFactory.createSBinary(binValue);

        binValue = "";
        for (int i=0; i<strSize; i++){
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin2 = TypeFactory.createSBinary(binValue);
    }

    /**
     * Tests for checking that the Negation class functions correctly with the booleans and binaries
     */
    @RepeatedTest(N)
    void negationTest() {
        var a = new Negation(bool);
        assertEquals(bool.negation(), a.eval());

        var b = new Negation(bin);
        assertEquals(bin.negation(), b.eval());
    }

    /**
     * Tests for checking that the Conjunction class functions correctly, evaluating the different values
     * of different types.
     */
    @RepeatedTest(N)
    void conjunctionTest() {
        var a = new Conjunction(bool, bool2);
        assertEquals(bool.conj(bool2), a.eval());

        var b = new Conjunction(bin, bin2);
        assertEquals(bin.conj(bin2), b.eval());

        var c = new Conjunction(bool, bin);
        assertEquals(bool.conj(bin), c.eval());

        var d = new Conjunction(bin2, bool2);
        assertEquals(bin2.conj(bool2), d.eval());
    }

    /**
     * Tests for checking that the Disjunction class functions correctly, evaluating the different values
     * of different types.
     */
    @RepeatedTest(N)
    void disjunctionTest() {
        var a = new Disjunction(bool, bool2);
        assertEquals(bool.disj(bool2), a.eval());

        var b = new Disjunction(bin, bin2);
        assertEquals(bin.disj(bin2), b.eval());

        var c = new Disjunction(bool, bin);
        assertEquals(bool.disj(bin), c.eval());

        var d = new Disjunction(bin2, bool2);
        assertEquals(bin2.disj(bool2), d.eval());
    }
}
