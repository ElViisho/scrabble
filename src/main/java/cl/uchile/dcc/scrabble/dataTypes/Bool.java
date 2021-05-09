package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Bool type. It encapsulates a native Java boolean
 * that has the value of the instance
 */
public class Bool extends AbstractDataType {
    private final boolean value;

    /**
     * The constructor of the class
     * @param bool The value that will be assigned to the instance
     */
    public Bool(boolean bool){
        super(Boolean.toString(bool));
        this.value = bool;
    }

}
