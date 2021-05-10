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
        super(Integer.toString(n));
        this.value = n;
    }

}
