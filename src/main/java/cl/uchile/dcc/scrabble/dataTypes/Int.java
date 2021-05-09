package cl.uchile.dcc.scrabble.dataTypes;

public class Int implements IdataTypes{
    private final int value;

    /**
     * The constructor of the class
     * @param n The value that will be assigned to the instance
     */
    public Int(int n){
        this.value = n;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Int){
            var o = (Int) obj;
            return o.value == this.value;
        }
        return false;
    }

    @Override
    public String toString(){
        Integer n = this.value;
        return n.toString();
    }
}
