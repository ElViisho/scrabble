package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Conjunction implements Component{
    IdataTypes value;

    public Conjunction(Component component1, Component component2){
        this.value = component1.eval().conjunction(component2.eval());
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
