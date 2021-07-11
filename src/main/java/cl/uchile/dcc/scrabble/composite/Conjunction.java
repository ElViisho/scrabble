package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The logical conjunction operation class. When evaluated it returns
 * the conjunction of the values passed to it when constructed
 */
public class Conjunction extends AbstractOperation{
    private Component value1;
    private Component value2;

    /**
     * The constructor of the class
     * @param component1 The first component of the operation
     * @param component2 The second component of the operation
     */
    public Conjunction(Component component1, Component component2){
        this.value1 = component1;
        this.value2 = component2;
    }

    /**
     * {@inheritDoc}
     * @return the conjunction between its two parameters
     */
    @Override
    public IdataTypes eval() {
        return value1.eval().conjunction(value2.eval());
    }
}
