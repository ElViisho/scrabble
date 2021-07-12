package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The logical negation operation class. When evaluated it returns
 * the negation of the value passed to it when constructed
 */
public class Negation extends AbstractOperation {
    Component value;

    /**
     * The constructor of the class
     * @param component The component to be negated
     */
    public Negation(Component component){
        this.value = component;
    }

    /**
     * {@inheritDoc}
     * @return the negation of its parameter
     */
    @Override
    public IdataTypes eval() {
        return value.eval().negate();
    }
}
