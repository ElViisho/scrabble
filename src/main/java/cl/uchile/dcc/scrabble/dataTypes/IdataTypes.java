package cl.uchile.dcc.scrabble.dataTypes;

import cl.uchile.dcc.scrabble.composite.Leaf;

/**
 * Interface to be implemented by the abstract Scrabble data type class
 */
public interface IdataTypes extends Leaf{
    /**
     * Compares the values of the current instance with another object's
     * to see if they're equal
     * @param obj the object to be compared with
     * @return whether the values are the same
     */
    @Override
    boolean equals(Object obj);

    /**
     * @return the hash code of the object
     */
    @Override
    int hashCode();

    /**
     * @return The value inside an instance of an object
     *         in the form of a Java String
     */
    @Override
    String toString();

    /**
     * Transforms the current instance to a scrabble String instance
     * @return the transformed instance
     */
    scrabbleString toScrabString();

    /**
     * Transforms the current instance to a scrabble Bool instance
     * @return the transformed instance
     */
    scrabbleBool toScrabBool();

    /**
     * Transforms the current instance to a scrabble Float instance
     * @return the transformed instance
     */
    scrabbleFloat toScrabFloat();

    /**
     * Transforms the current instance to a scrabble Int instance
     * @return the transformed instance
     */
    scrabbleInt toScrabInt();

    /**
     * Transforms the current instance to a scrabble Binary instance
     * @return the transformed instance
     */
    scrabbleBinary toScrabBinary();


    /**
     * For using double dispatch. This will be concatenated at the end of s
     * @param s the string that will concatenate this
     * @return the concatenated string
     */
    scrabbleString sumByString(scrabbleString s);

    IdataTypes add(IdataTypes eval);

    IdataTypes subtract(IdataTypes eval);

    IdataTypes multiplicate(IdataTypes eval);

    IdataTypes divide(IdataTypes eval);
}
