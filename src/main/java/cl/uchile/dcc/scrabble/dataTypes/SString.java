package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the string class
 * It encapsulates all the concatenations with other types
 */
public interface SString {
    /**
     * Concatenates the values of this with a string
     * @param string the string to be concatenated
     * @return the concatenated string
     */
    public scrabbleString sumString(scrabbleString string);

    /** Concatenates the values of this with a boolean
     * @param bool the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    public scrabbleString sumBool(scrabbleBool bool);

    /** Concatenates the values of this with a float
     * @param x the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    public scrabbleString sumFloat(scrabbleFloat x);

    /** Concatenates the values of this with an integer
     * @param n the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    public scrabbleString sumInt(scrabbleInt n);

    /** Concatenates the values of this with a binary
     * @param bin the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    public scrabbleString sumBinary(scrabbleBinary bin);
}
