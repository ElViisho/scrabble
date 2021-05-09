package cl.uchile.dcc.scrabble.dataTypes;

public class Float implements IdataTypes{
    private final double value;

    /**
     * The constructor of the class
     * @param n The value that will be assigned to the instance
     */
    public Float(double n){
        this.value = n;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Float){
            var o = (Float) obj;
            return o.value == this.value;
        }
        return false;
    }

    @Override
    public String toString(){
        Double x = this.value;
        return x.toString();
    }
}
