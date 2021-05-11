package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Binary class. It encapsulates a native Java String
 * that has the value of the instance, composed of only 0s and 1s
 */
public class scrabbleBinary extends AbstractDataType{
    private final String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleBinary(String str) {
        super(str);
        this.value = str;
    }

    @Override
    public scrabbleString toScrabString() {
        return new scrabbleString(value);
    }

    @Override
    public scrabbleBinary toScrabBinary() {
        return this;
    }
}
