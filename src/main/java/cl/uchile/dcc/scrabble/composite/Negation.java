package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Negation extends AbstractOperation {
    Component value;

    public Negation(Component component){
        this.value = component;
    }

    @Override
    public IdataTypes eval() {
        return value.eval().negate();
    }
}
