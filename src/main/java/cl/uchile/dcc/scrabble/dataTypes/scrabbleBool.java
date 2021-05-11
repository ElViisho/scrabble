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
        this.value = bool;
        super.value = this.value;
    }

    @Override
    public scrabbleString toScrabString() {
        String s = String.valueOf(value);
        return new scrabbleString(s);
    }

    @Override
    public scrabbleBool toScrabBool(){
        return this;
    }

}
