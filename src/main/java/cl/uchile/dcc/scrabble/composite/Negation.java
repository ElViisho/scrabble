package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Negation implements Composite{
    IdataTypes value;

    public Negation(Component component){
        this.value = component.eval().negate();
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
