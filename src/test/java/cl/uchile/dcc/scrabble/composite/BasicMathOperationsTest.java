package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BasicMathOperationsTest {

    private scrabbleInt n;
    private scrabbleInt n2;

    private scrabbleFloat x;
    private scrabbleFloat x2;

    private scrabbleBinary bin;
    private scrabbleBinary bin2;

    private scrabbleString string;
    private scrabbleString string2;

    private scrabbleBool bool;

    private final int N = 100;
    private Random rng;
    private int strSize;

    @BeforeEach
    void setUp(){
        int seed = new Random().nextInt();
        rng = new Random(seed);

        int nValue = rng.nextInt();
        n = new scrabbleInt(nValue);
        nValue = rng.nextInt();
        n2 = new scrabbleInt(nValue);

        double xValue = rng.nextDouble();
        x = new scrabbleFloat(xValue);
        xValue = rng.nextDouble();
        x2 = new scrabbleFloat(xValue);

        String binValue = "";
        strSize = rng.nextInt(20) + 1;
        for (int i = 0; i< strSize; i++){
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin = new scrabbleBinary(binValue);
        binValue = "";
        for (int i = 0; i< strSize; i++){
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin2 = new scrabbleBinary(binValue);

        String str = randomAlphanumeric(strSize);
        string = new scrabbleString(str);
        str = randomAlphanumeric(strSize);
        string2 = new scrabbleString(str);

        bool = new scrabbleBool(rng.nextBoolean());
    }

    @RepeatedTest(N)
    void Addtest(){
        var a = new Add(n, n2);
        assertEquals(n.sum(n2), a.eval());

        var b = new Add(x, x2);
        assertEquals(x.sum(x2), b.eval());

        var c = new Add(bin, bin2);
        assertEquals(bin.sum(bin2), c.eval());

        var d = new Add(n, x);
        assertEquals(n.sum(x), d.eval());

        var e = new Add(n, bin);
        assertEquals(n.sum(bin), e.eval());

        var f = new Add(x, n);
        assertEquals(x.sum(n), f.eval());

        var g = new Add(x, bin);
        assertEquals(x.sum(bin), g.eval());

        var h = new Add(bin, n);
        assertEquals(bin.sum(n), h.eval());
    }

    @RepeatedTest(N)
    void Subtest(){
        var a = new Sub(n, n2);
        assertEquals(n.subs(n2), a.eval());

        var b = new Sub(x, x2);
        assertEquals(x.subs(x2), b.eval());

        var c = new Sub(bin, bin2);
        assertEquals(bin.subs(bin2), c.eval());

        var d = new Sub(n, x);
        assertEquals(n.subs(x), d.eval());

        var e = new Sub(n, bin);
        assertEquals(n.subs(bin), e.eval());

        var f = new Sub(x, n);
        assertEquals(x.subs(n), f.eval());

        var g = new Sub(x, bin);
        assertEquals(x.subs(bin), g.eval());

        var h = new Sub(bin, n);
        assertEquals(bin.subs(n), h.eval());
    }

    @RepeatedTest(N)
    void Multtest(){
        var a = new Mult(n, n2);
        assertEquals(n.mult(n2), a.eval());

        var b = new Mult(x, x2);
        assertEquals(x.mult(x2), b.eval());

        var c = new Mult(bin, bin2);
        assertEquals(bin.mult(bin2), c.eval());

        var d = new Mult(n, x);
        assertEquals(n.mult(x), d.eval());

        var e = new Mult(n, bin);
        assertEquals(n.mult(bin), e.eval());

        var f = new Mult(x, n);
        assertEquals(x.mult(n), f.eval());

        var g = new Mult(x, bin);
        assertEquals(x.mult(bin), g.eval());

        var h = new Mult(bin, n);
        assertEquals(bin.mult(n), h.eval());
    }

    @RepeatedTest(N)
    void Divtest(){
        do {
            n2 = new scrabbleInt(rng.nextInt());
        } while (n2.getValue() == 0);
        var a = new Div(n, n2);
        assertEquals(n.div(n2), a.eval());

        do {
            x2 = new scrabbleFloat(rng.nextDouble());
        } while (x2.getValue() == 0);
        var b = new Div(x, x2);
        assertEquals(x.div(x2), b.eval());

        do {
            String binValue = "";
            strSize = rng.nextInt(20) + 1;
            for (int i = 0; i< strSize; i++){
                int n = rng.nextInt(2);
                binValue += Integer.toString(n);
            }
            bin2 = new scrabbleBinary(binValue);
        } while (bin2.equals(new scrabbleBinary("0")));
        var c = new Div(bin, bin2);
        assertEquals(bin.div(bin2), c.eval());

        do {
            x = new scrabbleFloat(rng.nextDouble());
        } while (x.getValue() == 0);
        var d = new Div(n, x);
        assertEquals(n.div(x), d.eval());

        do {
            String binValue = "";
            strSize = rng.nextInt(20) + 1;
            for (int i = 0; i< strSize; i++){
                int n = rng.nextInt(2);
                binValue += Integer.toString(n);
            }
            bin = new scrabbleBinary(binValue);
        } while (bin.equals(new scrabbleBinary("0")));
        var e = new Div(n, bin);
        assertEquals(n.div(bin), e.eval());

        do {
            n = new scrabbleInt(rng.nextInt());
        } while (n.getValue() == 0);
        var f = new Div(x, n);
        assertEquals(x.div(n), f.eval());

        var g = new Div(x, bin);
        assertEquals(x.div(bin), g.eval());

        var h = new Div(bin, n);
        assertEquals(bin.div(n), h.eval());
    }

    @RepeatedTest(N)
    void StringTest() {
        var a = new Add(string, string2);
        assertEquals(string.concatenate(string2), a.eval());

        var b = new Add(string, n);
        assertEquals(string.concatenate(n), b.eval());

        var c = new Add(string, x);
        assertEquals(string.concatenate(x), c.eval());

        var d = new Add(string, bin);
        assertEquals(string.concatenate(bin), d.eval());

        var e = new Add(string, bool);
        assertEquals(string.concatenate(bool), e.eval());
    }

}
