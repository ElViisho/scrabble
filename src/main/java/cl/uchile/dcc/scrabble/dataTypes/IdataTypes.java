package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the different Scrabble data types
 */
public interface IdataTypes {
    /**
     * @return The value inside an instance of an object
     *         in the form of a Java String
     */
    @Override
    String toString();
    /**
     * Compares the values of the current instance with another object's
     * to see if they're equal
     * @param obj the object to be compared with
     * @return whether the values are the same
     */
    @Override
    boolean equals(Object obj);
}
