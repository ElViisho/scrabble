package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The logical disjunction operation class. When evaluated it returns
 * the disjunction of the values passed to it when constructed
 */
public class Disjunction extends AbstractOperation {
    private Component value1;
    private Component value2;

    /**
     * The constructor of the class
     * @param component1 The first component of the operation
     * @param component2 The second component of the operation
     */
    public Disjunction(Component component1, Component component2){
        this.value1 = component1;
        this.value2 = component2;
    }

    /**
     * {@inheritDoc}
     * @return the disjunction between its two parameters
     */
    @Override
    public IdataTypes eval() {
        return value1.eval().disjunction(value2.eval());
    }
}
