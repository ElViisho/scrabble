package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Add implements Composite{
    private IdataTypes value;

    public Add(Component component1, Component component2){
        this.value = component1.eval().add(component2.eval());
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
