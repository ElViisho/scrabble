package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble String class. It encapsulates a native Java String
 * that has the value of the instance
 */
public class scrabbleString extends AbstractDataType {
    private final String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleString(String str){
        this.value = str;
        super.value = this.value;
    }

    @Override
    public scrabbleString toScrabString() {
        return this;
    }
}
