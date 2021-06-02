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
        super.value = this.value;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleString toScrabString() {
        return this;
    }

    /**
     * {@inheritDoc}
     * @param i the value to be concatenated. It transforms into a string before
     * @return the concatenated string
     */
    @Override
    public scrabbleString sum(AbstractDataType i){
        return i.sumByString(this);
    }

}
