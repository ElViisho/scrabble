package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The division operation class. When evaluated it returns
 * the division of the values passed to it when constructed
 */
public class Div extends AbstractOperation {
    private Component value1;
    private Component value2;

    /**
     * The constructor of the class
     * @param component1 The first component of the operation
     * @param component2 the value that will divide component1
     */
    public Div(Component component1, Component component2) {
        this.value1 = component1;
        this.value2 = component2;
    }

    /**
     * {@inheritDoc}
     * @return the multiplication between its two parameters
     */
    @Override
    public IdataTypes eval() {
        return value1.eval().divide(value2.eval());
    }
}
