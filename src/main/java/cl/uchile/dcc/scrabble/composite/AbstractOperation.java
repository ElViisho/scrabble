package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;

/**
 * The parent class for every operation class (Composite node of a tree).
 * It implements all the transformations between types.
 * Since eval() returns an instance of IdataTypes, and every data type
 * has all the transformations already implemented, it just calls those
 * methods.
 */
public abstract class AbstractOperation implements Operation {

    /**
     * {@inheritDoc}
     * @return the transformed value if transformation is valid, or null otherwise
     */
    @Override
    public scrabbleString toSString() {
        return this.eval().toScrabString();
    }

    /**
     * {@inheritDoc}
     * @return the transformed value if transformation is valid, or null otherwise
     */
    @Override
    public scrabbleBool toBool() {
        return this.eval().toScrabBool();
    }

    /**
     * {@inheritDoc}
     * @return the transformed value if transformation is valid, or null otherwise
     */
    @Override
    public scrabbleFloat toFloat() {
        return this.eval().toScrabFloat();
    }

    /**
     * {@inheritDoc}
     * @return the transformed value if transformation is valid, or null otherwise
     */
    @Override
    public scrabbleInt toInt() {
        return this.eval().toScrabInt();
    }

    /**
     * {@inheritDoc}
     * @return the transformed value if transformation is valid, or null otherwise
     */
    @Override
    public scrabbleBinary toBinary() {
        return this.eval().toScrabBinary();
    }
}
