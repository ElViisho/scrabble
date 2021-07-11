package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NullTest {
    private scrabbleInt n;

    private scrabbleFloat x;

    private scrabbleBinary bin;

    private scrabbleString string;

    private scrabbleBool bool;

    private final int N = 100;
    private Random rng;
    private int strSize;

    /**
     * The set up to be done before each test.
     * The values are generated at random so that the tests are not biased
     */
    @BeforeEach
    void setUp() {
        int seed = new Random().nextInt();
        rng = new Random(seed);

        int nValue = rng.nextInt();
        n = new scrabbleInt(nValue);

        double xValue = rng.nextDouble();
        x = new scrabbleFloat(xValue);

        String binValue = "";
        strSize = rng.nextInt(20) + 1;
        for (int i = 0; i < strSize; i++) {
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin = new scrabbleBinary(binValue);

        String str = randomAlphanumeric(strSize);
        string = new scrabbleString(str);

        bool = new scrabbleBool(rng.nextBoolean());
    }

    /**
     * Test from now onward check that all operations that are not valid return null.
     */


    @RepeatedTest(N)
    void AddTest() {
        var a = new Add(n, string);
        assertNull(a.eval());
        var b = new Add(n, bool);
        assertNull(b.eval());

        var c = new Add(x, string);
        assertNull(c.eval());
        var d = new Add(x, bool);
        assertNull(d.eval());

        var e = new Add(bin, x);
        assertNull(e.eval());
        var f = new Add(bin, string);
        assertNull(f.eval());
        var g = new Add(bin, bool);
        assertNull(g.eval());

        var h = new Add(bool, n);
        assertNull(h.eval());
        var i = new Add(bool, x);
        assertNull(i.eval());
        var j = new Add(bool, string);
        assertNull(j.eval());
        var k = new Add(bool, bool);
        assertNull(k.eval());
        var l = new Add(bool, bin);
        assertNull(l.eval());
    }

    @RepeatedTest(N)
    void SubTest() {
        var a = new Sub(n, string);
        assertNull(a.eval());
        var b = new Sub(n, bool);
        assertNull(b.eval());

        var c = new Sub(x, string);
        assertNull(c.eval());
        var d = new Sub(x, bool);
        assertNull(d.eval());

        var e = new Sub(bin, x);
        assertNull(e.eval());
        var f = new Sub(bin, string);
        assertNull(f.eval());
        var g = new Sub(bin, bool);
        assertNull(g.eval());

        var h = new Sub(bool, n);
        assertNull(h.eval());
        var i = new Sub(bool, x);
        assertNull(i.eval());
        var j = new Sub(bool, string);
        assertNull(j.eval());
        var k = new Sub(bool, bool);
        assertNull(k.eval());
        var l = new Sub(bool, bin);
        assertNull(l.eval());

        var m = new Sub(string, n);
        assertNull(m.eval());
        var n = new Sub(string, x);
        assertNull(n.eval());
        var o = new Sub(string, string);
        assertNull(o.eval());
        var p = new Sub(string, bool);
        assertNull(p.eval());
        var q = new Sub(string, bin);
        assertNull(q.eval());
    }

    @RepeatedTest(N)
    void MultTest() {
        var a = new Mult(n, string);
        assertNull(a.eval());
        var b = new Mult(n, bool);
        assertNull(b.eval());

        var c = new Mult(x, string);
        assertNull(c.eval());
        var d = new Mult(x, bool);
        assertNull(d.eval());

        var e = new Mult(bin, x);
        assertNull(e.eval());
        var f = new Mult(bin, string);
        assertNull(f.eval());
        var g = new Mult(bin, bool);
        assertNull(g.eval());

        var h = new Mult(bool, n);
        assertNull(h.eval());
        var i = new Mult(bool, x);
        assertNull(i.eval());
        var j = new Mult(bool, string);
        assertNull(j.eval());
        var k = new Mult(bool, bool);
        assertNull(k.eval());
        var l = new Mult(bool, bin);
        assertNull(l.eval());

        var m = new Mult(string, n);
        assertNull(m.eval());
        var n = new Mult(string, x);
        assertNull(n.eval());
        var o = new Mult(string, string);
        assertNull(o.eval());
        var p = new Mult(string, bool);
        assertNull(p.eval());
        var q = new Mult(string, bin);
        assertNull(q.eval());
    }

    @RepeatedTest(N)
    void DivTest() {
        var a = new Div(n, string);
        assertNull(a.eval());
        var b = new Div(n, bool);
        assertNull(b.eval());

        var c = new Div(x, string);
        assertNull(c.eval());
        var d = new Div(x, bool);
        assertNull(d.eval());

        var e = new Div(bin, x);
        assertNull(e.eval());
        var f = new Div(bin, string);
        assertNull(f.eval());
        var g = new Div(bin, bool);
        assertNull(g.eval());

        var h = new Div(bool, n);
        assertNull(h.eval());
        var i = new Div(bool, x);
        assertNull(i.eval());
        var j = new Div(bool, string);
        assertNull(j.eval());
        var k = new Div(bool, bool);
        assertNull(k.eval());
        var l = new Div(bool, bin);
        assertNull(l.eval());

        var m = new Div(string, n);
        assertNull(m.eval());
        var n = new Div(string, x);
        assertNull(n.eval());
        var o = new Div(string, string);
        assertNull(o.eval());
        var p = new Div(string, bool);
        assertNull(p.eval());
        var q = new Div(string, bin);
        assertNull(q.eval());
    }

    @RepeatedTest(N)
    void NegTest() {
        var a = new Negation(n);
        assertNull(a.eval());

        var b = new Negation(x);
        assertNull(b.eval());

        var c = new Negation(string);
        assertNull(c.eval());
    }

    @RepeatedTest(N)
    void ConjTest() {
        var a = new Conjunction(n, n);
        assertNull(a.eval());
        var b = new Conjunction(n, x);
        assertNull(b.eval());
        var c = new Conjunction(n, string);
        assertNull(c.eval());
        var d = new Conjunction(n, bool);
        assertNull(d.eval());
        var e = new Conjunction(n, bin);
        assertNull(e.eval());

        var f = new Conjunction(x, n);
        assertNull(f.eval());
        var g = new Conjunction(x,x);
        assertNull(g.eval());
        var h = new Conjunction(x, string);
        assertNull(h.eval());
        var i = new Conjunction(x, bool);
        assertNull(i.eval());
        var j = new Conjunction(x, bin);
        assertNull(j.eval());

        var k = new Conjunction(string, n);
        assertNull(k.eval());
        var l = new Conjunction(string, x);
        assertNull(l.eval());
        var m = new Conjunction(string, string);
        assertNull(m.eval());
        var nn = new Conjunction(string, bool);
        assertNull(nn.eval());
        var o = new Conjunction(string, bin);
        assertNull(o.eval());

        var p = new Conjunction(bool, n);
        assertNull(p.eval());
        var q = new Conjunction(bool, x);
        assertNull(q.eval());
        var r = new Conjunction(bool, string);
        assertNull(r.eval());

        var s = new Conjunction(bin, n);
        assertNull(s.eval());
        var t = new Conjunction(bin, x);
        assertNull(t.eval());
        var u = new Conjunction(bin, string);
        assertNull(u.eval());
    }

    @RepeatedTest(N)
    void DisjTest() {
        var a = new Disjunction(n, n);
        assertNull(a.eval());
        var b = new Disjunction(n, x);
        assertNull(b.eval());
        var c = new Disjunction(n, string);
        assertNull(c.eval());
        var d = new Disjunction(n, bool);
        assertNull(d.eval());
        var e = new Disjunction(n, bin);
        assertNull(e.eval());

        var f = new Disjunction(x, n);
        assertNull(f.eval());
        var g = new Disjunction(x,x);
        assertNull(g.eval());
        var h = new Disjunction(x, string);
        assertNull(h.eval());
        var i = new Disjunction(x, bool);
        assertNull(i.eval());
        var j = new Disjunction(x, bin);
        assertNull(j.eval());

        var k = new Disjunction(string, n);
        assertNull(k.eval());
        var l = new Disjunction(string, x);
        assertNull(l.eval());
        var m = new Disjunction(string, string);
        assertNull(m.eval());
        var nn = new Disjunction(string, bool);
        assertNull(nn.eval());
        var o = new Disjunction(string, bin);
        assertNull(o.eval());

        var p = new Disjunction(bool, n);
        assertNull(p.eval());
        var q = new Disjunction(bool, x);
        assertNull(q.eval());
        var r = new Disjunction(bool, string);
        assertNull(r.eval());

        var s = new Disjunction(bin, n);
        assertNull(s.eval());
        var t = new Disjunction(bin, x);
        assertNull(t.eval());
        var u = new Disjunction(bin, string);
        assertNull(u.eval());
    }
}
