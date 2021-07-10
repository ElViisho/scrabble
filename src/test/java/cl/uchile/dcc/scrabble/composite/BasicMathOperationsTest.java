package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BasicMathOperationsTest {

    private scrabbleInt n;
    private scrabbleInt n2;

    private scrabbleFloat x;
    private scrabbleFloat x2;

    private scrabbleBinary bin;
    private scrabbleBinary bin2;

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
    }

    @RepeatedTest(N)
    void Addtest(){
        var a = new Add(n, n2);
        assertEquals(a.eval(), n.sum(n2));

        var b = new Add(x, x2);
        assertEquals(b.eval(), x.add(x2));

        var c = new Add(bin, bin2);
        assertEquals(c.eval(), bin.add(bin2));

        var d = new Add(n, x);
        assertEquals(d.eval(), n.add(x));

        var e = new Add(n, bin);
        assertEquals(e.eval(), n.add(bin));

        var f = new Add(x, n);
        assertEquals(f.eval(), x.add(n));

        var g = new Add(x, bin);
        assertEquals(g.eval(), x.add(bin));

        var h = new Add(bin, n);
        assertEquals(h.eval(), bin.add(n));
    }

    @RepeatedTest(N)
    void Subtest(){
        var a = new Sub(n, n2);
        assertEquals(a.getValue(), n.subs(n2));

        var b = new Sub(x, x2);
        assertEquals(b.getValue(), x.subs(x2));

        var c = new Sub(bin, bin2);
        assertEquals(c.getValue(), bin.subs(bin2));

        var d = new Sub(n, x);
        assertEquals(d.getValue(), n.subs(x));

        var e = new Sub(n, bin);
        assertEquals(e.getValue(), n.subs(bin));

        var f = new Sub(x, n);
        assertEquals(f.getValue(), x.subs(n));

        var g = new Sub(x, bin);
        assertEquals(g.getValue(), x.subs(bin));

        var h = new Sub(bin, n);
        assertEquals(h.getValue(), bin.subs(n));
    }

    @RepeatedTest(N)
    void Multtest(){
        var a = new Mult(n, n2);
        assertEquals(a.getValue(), n.mult(n2));

        var b = new Mult(x, x2);
        assertEquals(b.getValue(), x.mult(x2));

        var c = new Mult(bin, bin2);
        assertEquals(c.getValue(), bin.mult(bin2));

        var d = new Mult(n, x);
        assertEquals(d.getValue(), n.mult(x));

        var e = new Mult(n, bin);
        assertEquals(e.getValue(), n.mult(bin));

        var f = new Mult(x, n);
        assertEquals(f.getValue(), x.mult(n));

        var g = new Mult(x, bin);
        assertEquals(g.getValue(), x.mult(bin));

        var h = new Mult(bin, n);
        assertEquals(h.getValue(), bin.mult(n));
    }

    @RepeatedTest(N)
    void Divtest(){
        do {
            n2 = new scrabbleInt(rng.nextInt());
        } while (n2.getValue() == 0);
        var a = new Div(n, n2);
        assertEquals(a.getValue(), n.div(n2));

        do {
            x2 = new scrabbleFloat(rng.nextDouble());
        } while (x2.getValue() == 0);
        var b = new Div(x, x2);
        assertEquals(b.getValue(), x.div(x2));

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
        assertEquals(c.getValue(), bin.div(bin2));

        do {
            x = new scrabbleFloat(rng.nextDouble());
        } while (x.getValue() == 0);
        var d = new Div(n, x);
        assertEquals(d.getValue(), n.div(x));

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
        assertEquals(e.getValue(), n.div(bin));

        do {
            n = new scrabbleInt(rng.nextInt());
        } while (n.getValue() == 0);
        var f = new Div(x, n);
        assertEquals(f.getValue(), x.div(n));

        var g = new Div(x, bin);
        assertEquals(g.getValue(), x.div(bin));

        var h = new Div(bin, n);
        assertEquals(h.getValue(), bin.div(n));
    }
    
}
