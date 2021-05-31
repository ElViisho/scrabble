package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble String class. It encapsulates a native Java String
 * that has the value of the instance
 */
public class scrabbleString extends AbstractDataType {
    private String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleString(String str){
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
    protected void setValue(String value) {
        this.value = value;
    }

    @Override
    public scrabbleString toScrabString() {
        return this;
    }

    public scrabbleString sumString(scrabbleString string){
        String newStr = this.value + string.getValue();
        return new scrabbleString(newStr);
    }

    public scrabbleString sumBool(scrabbleBool bool){
        String newStr = this.value + bool.toString();
        return new scrabbleString(newStr);
    }

    public scrabbleString sumFloat(scrabbleFloat x){
        String newStr = this.value + x.toString();
        return new scrabbleString(newStr);
    }

    public scrabbleString sumInt(scrabbleInt n){
        String newStr = this.value + n.toString();
        return new scrabbleString(newStr);
    }

    public scrabbleString sumBinary(scrabbleBinary bin){
        String newStr = this.value + bin.toString();
        return new scrabbleString(newStr);
    }
}
