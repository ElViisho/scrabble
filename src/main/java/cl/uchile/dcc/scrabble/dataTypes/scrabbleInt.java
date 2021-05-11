package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Int class. It encapsulates a native Java int
 * that has the value of the instance
 */
public class scrabbleInt extends AbstractDataType{
    private final int value;

    /**
     * The constructor of the class
     * @param n The value that will be assigned to the instance
     */
    public scrabbleInt(int n){
        this.value = n;
        super.value = this.value;
    }

    @Override
    public scrabbleString toScrabString() {
        String s = String.valueOf(value);
        return new scrabbleString(s);
    }

    @Override
    public scrabbleFloat toScrabFloat() {
        return new scrabbleFloat(value);
    }

    @Override
    public scrabbleInt toScrabInt() {
        return this;
    }
}
