package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;
import cl.uchile.dcc.scrabble.dataTypes.SNumber;

public class Mult implements Composite {
    private IdataTypes value;

    public Mult(Component component1, Component component2) {
        this.value = ((SNumber) component1.eval()).mult((SNumber) component2.eval());
    }

    public IdataTypes getValue() {
        return this.value;
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
