package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

public class Disjunction implements Composite{
    IdataTypes value;

    public Disjunction(Component component1, Component component2){
        this.value = component1.eval().disjunction(component2.eval());
    }

    @Override
    public IdataTypes eval() {
        return this.value;
    }
}
