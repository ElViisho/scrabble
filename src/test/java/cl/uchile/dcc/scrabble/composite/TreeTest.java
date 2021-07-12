package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests that check different trees
 */
public class TreeTest {

    private scrabbleInt n;
    private scrabbleInt n2;

    private scrabbleFloat x;
    private scrabbleFloat x2;

    private scrabbleBinary bin;
    private scrabbleBinary bin2;

    private scrabbleString string;
    private scrabbleString string2;

    private scrabbleBool bool;
    private scrabbleBool bool2;

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
        n = TypeFactory.createSInt(nValue);
        nValue = rng.nextInt();
        n2 = TypeFactory.createSInt(nValue);

        double xValue = rng.nextDouble();
        x = TypeFactory.createSFloat(xValue);
        xValue = rng.nextDouble();
        x2 = TypeFactory.createSFloat(xValue);

        String binValue = "";
        strSize = rng.nextInt(20) + 1;
        for (int i = 0; i < strSize; i++) {
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin = TypeFactory.createSBinary(binValue);
        binValue = "";
        for (int i = 0; i < strSize; i++) {
            int n = rng.nextInt(2);
            binValue += Integer.toString(n);
        }
        bin2 = TypeFactory.createSBinary(binValue);

        String str = randomAlphanumeric(strSize);
        string = TypeFactory.createSString(str);
        str = randomAlphanumeric(strSize);
        string2 = TypeFactory.createSString(str);

        bool = TypeFactory.createSBool(rng.nextBoolean());
        bool2 = TypeFactory.createSBool(rng.nextBoolean());
    }

    @RepeatedTest(N)
    void Test(){
        var a = new Add(
                x,
                new Disjunction(
                        bin,
                        new Sub(
                                n,
                                bin2
                        ).toBinary()
                )
        );
        assertNotNull(a.eval());
        assertEquals(x.sum((SNumber) bin.disj((
                n.subs(bin2)
                ).toScrabBinary())),
                a.eval());
    }

    @RepeatedTest(N)
    void Test2(){
        var x2_2 = x2;
        do {
            x2_2 = new scrabbleFloat(rng.nextDouble());
        } while (x2_2.equals(new scrabbleFloat(0)));

        var a = new Mult(
                n2,
                new Sub(
                        new Conjunction(
                                new Negation(bin2),
                                bool
                        ).toFloat(),
                        new Div(n,x2_2)
                )
        );
        assertNotNull(a.eval());
        assertEquals(n2.mult(
                (bin2.negation().conj(bool)
                ).toScrabFloat().subs(
                        n.div(x2_2)
                )),
                a.eval());
    }


    @RepeatedTest(N)
    void Test3() {
        var a = new Negation(
                new Add(
                        new Disjunction(
                                new Negation(bool2).toBool(),
                                bin2
                        ).toInt(),
                        new Mult(
                                new Sub(
                                        new Add(
                                                n2,
                                                n
                                        ),
                                        bin
                                ), new Conjunction(
                                        bin, bin2
                                ).toBinary()
                        )
                ).toBinary()
        );
        assertNotNull(a.eval());
        assertEquals(
                ((bool2.negation().toScrabBool().disj(bin2)).add(((n2.sum(n)).subs(bin))
                        .mult(bin.conj(bin2).toScrabBinary()))).toScrabBinary().negation(),
                a.eval());
    }

    @RepeatedTest(N)
    void Test4() {
        var n2_2 = n2;
        do {
            n2_2 = new scrabbleInt(rng.nextInt());
        } while (n2_2.equals(new scrabbleInt(0)));

        var a = new Add(
                new Conjunction(
                        bool,
                        new Sub(
                                bin2,
                                new Div(
                                        n,
                                        n2_2
                                )
                        ).toBinary()
                ).toSString(),
                new Add(
                        string,
                        new Add(
                                string2,
                                new Add(
                                        new Add(
                                                new Mult(
                                                        new Negation(bin).toInt(),
                                                        new Mult(
                                                                n,
                                                                bin2
                                                        ).toFloat()
                                                ).toSString(),
                                                x
                                        ).toSString(),
                                        new Div(
                                                x2,
                                                n2_2
                                        )
                                )
                        )
                )
        );

        assertNotNull(a.eval());
        assertEquals(
                (bool.conj((bin2.subs(n.div(n2_2))).toScrabBinary())).toScrabString()
                        .add(string.add(string2.add(((bin.negation().toScrabInt())
                                .mult(n.mult(bin2).toScrabFloat())).toScrabString().add(x).add(x2.div(n2_2))))),
                a.eval());
    }
}
