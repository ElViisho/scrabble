package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The multiplication operation class. When evaluated it returns
 * the multiplication of the values passed to it when constructed
 */
public class Mult extends AbstractOperation {
    private Component value1;
    private Component value2;

    /**
     * The constructor of the class
     * @param component1 The first component of the operation
     * @param component2 the value that will be multiplied with component1
     */
    public Mult(Component component1, Component component2) {
        this.value1 = component1;
        this.value2 = component2;
    }

    /**
     * {@inheritDoc}
     * @return the multiplication between its two parameters
     */
    @Override
    public IdataTypes eval() {
        return value1.eval().multiply(value2.eval());
    }
}
