package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Bool type. It encapsulates a native Java boolean
 * that has the value of the instance
 */
public class scrabbleBool extends AbstractDataType {
    private boolean value;

    /**
     * The constructor of the class
     * @param bool The value that will be assigned to the instance
     */
    public scrabbleBool(boolean bool) {
        this.value = bool;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public boolean getValue(){
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    protected void setValue(boolean value) {
        this.value = value;
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

    public scrabbleBool conjBool(scrabbleBool bool){
        return new scrabbleBool(this.value && bool.value);
    }

    public scrabbleBool disjBool(scrabbleBool bool){
        return new scrabbleBool(this.value || bool.value);
    }

    public scrabbleBinary conjBinary(scrabbleBinary bin){
        if (this.value){
            return new scrabbleBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '0';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    public scrabbleBinary disjBinary(scrabbleBinary bin){
        if (!this.value){
            return new scrabbleBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '1';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

}
