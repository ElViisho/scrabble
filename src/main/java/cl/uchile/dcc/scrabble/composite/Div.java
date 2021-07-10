package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Div implements Composite {
    private IdataTypes value;

    public Div(Component component1, Component component2) {
        this.value = component1.eval().divide(component2.eval());
    }

    public IdataTypes getValue() {
        return this.value;
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
