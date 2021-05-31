package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Binary class. It encapsulates a native Java String
 * that has the value of the instance, composed of only 0s and 1s
 */
public class scrabbleBinary extends AbstractDataType{
    private String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleBinary(String str) {
        this.value = str;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    public void setValue(String value) {
        this.value = value;
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
