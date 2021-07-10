package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the string class
 * It encapsulates all the concatenations with other types
 */
public interface SString extends IdataTypes{
    public scrabbleString concatenate(AbstractDataType i);
}
