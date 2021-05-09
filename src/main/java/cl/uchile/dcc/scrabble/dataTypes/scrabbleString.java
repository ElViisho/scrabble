package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble String class. It encapsulates a native Java String
 * that has the value of the instance
 */
public class scrabbleString implements IdataTypes {
    private final String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleString(String str){
        this.value = str;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof scrabbleString){
            var o = (scrabbleString) obj;
            return o.value.equals(this.value);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.value;
    }

}
