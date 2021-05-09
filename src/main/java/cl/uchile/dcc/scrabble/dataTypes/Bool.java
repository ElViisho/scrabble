package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Bool type. It encapsulates a native Java boolean
 * that has the value of the instance
 */
public class Bool implements IdataTypes {
    private final boolean value;

    /** The constructor of the class
     * @param bool The value that will be assigned to the instance
     */
    public Bool(boolean bool){
        this.value = bool;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Bool){
            var o = (Bool) obj;
            return o.value == this.value;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.value) return "true";
        return "false";
    }
}
