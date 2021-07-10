package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;
import cl.uchile.dcc.scrabble.dataTypes.SNumber;

public class Add implements Composite{
    private IdataTypes value;

    public Add(Component component1, Component component2){
        this.value = ((SNumber) component1.eval()).sum((SNumber) component2.eval());
    }

    public IdataTypes getValue() {
        return this.value;
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
