package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the string class
 * It encapsulates all the concatenations with other types
 */
public interface SString extends IdataTypes{
    /**
     * @param i the value that will be concatenated to this
     * @return the concatenated string
     */
    public scrabbleString concatenate(AbstractDataType i);
}
