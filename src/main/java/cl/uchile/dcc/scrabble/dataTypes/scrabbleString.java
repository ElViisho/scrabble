package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble String class. It encapsulates a native Java String
 * that has the value of the instance
 */
public class scrabbleString extends AbstractDataType implements SString{
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

    /**
     * {@inheritDoc}
     * @param string the string to be concatenated
     * @return the concatenated string
     */
    @Override
    public scrabbleString sumString(scrabbleString string){
        String newStr = this.value + string.getValue();
        return new scrabbleString(newStr);
    }

    /**
     * {@inheritDoc}
     * @param bool the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    @Override
    public scrabbleString sumBool(scrabbleBool bool){
        String newStr = this.value + bool.toString();
        return new scrabbleString(newStr);
    }

    /**
     * {@inheritDoc}
     * @param x the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    @Override
    public scrabbleString sumFloat(scrabbleFloat x){
        String newStr = this.value + x.toString();
        return new scrabbleString(newStr);
    }

    /**
     * {@inheritDoc}
     * @param n the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    @Override
    public scrabbleString sumInt(scrabbleInt n){
        String newStr = this.value + n.toString();
        return new scrabbleString(newStr);
    }

    /**
     * {@inheritDoc}
     * @param bin the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    @Override
    public scrabbleString sumBinary(scrabbleBinary bin){
        String newStr = this.value + bin.toString();
        return new scrabbleString(newStr);
    }
}
