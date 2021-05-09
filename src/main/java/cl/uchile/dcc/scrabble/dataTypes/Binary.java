package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Binary class. It encapsulates a native Java String
 * that has the value of the instance, composed of only 0s and 1s
 */
public class Binary extends AbstractDataType{
    private final String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public Binary(String str) {
        super(str);
        this.value = str;
    }
}
