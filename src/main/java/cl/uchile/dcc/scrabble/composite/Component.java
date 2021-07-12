package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.IdataTypes;

/**
 * The interface to be implemented by every class that is a node of the tree of the
 * composite pattern, which are operations and variables
 */
public interface Component {
    /**
     * Method to evaluate the value of a node, whether it be an operation or a variable
     * @return the evaluated value
     */
    IdataTypes eval();
}
