package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Mult implements Operation {
    private Component value1;
    private Component value2;

    public Mult(Component component1, Component component2) {
        this.value1 = component1;
        this.value2 = component2;
    }

    @Override
    public IdataTypes eval() {
        return value1.eval().multiply(value2.eval());
    }
}
