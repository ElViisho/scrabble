package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;
import cl.uchile.dcc.scrabble.dataTypes.scrabbleString;

public class Add extends AbstractOperation {
    private Component value1;
    private Component value2;

    public Add(Component component1, Component component2){
        this.value1 = component1;
        this.value2 = component2;
    }

    @Override
    public IdataTypes eval() {
        return value1.eval().add(value2.eval());
    }
}
