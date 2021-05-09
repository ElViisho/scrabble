package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the abstract Scrabble data type class
 */
public interface IdataTypes {
    /**
     * Compares the values of the current instance with another object's
     * to see if they're equal
     * @param obj the object to be compared with
     * @return whether the values are the same
     */
    @Override
    boolean equals(Object obj);

    /**
     * @return The value inside an instance of an object
     *         in the form of a Java String
     */
    @Override
    String toString();
}
