package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Bool type. It encapsulates a native Java boolean
 * that has the value of the instance
 */
public class scrabbleBool extends AbstractDataType {
    private final boolean value;

    /**
     * The constructor of the class
     * @param bool The value that will be assigned to the instance
     */
    public scrabbleBool(boolean bool){
        super(Boolean.toString(bool));
        this.value = bool;
    }

}
