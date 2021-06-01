package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Float class. It encapsulates a native Java double
 * that has the value of the instance
 */
public class scrabbleFloat extends AbstractNumber {
    private double value;

    /**
     * The constructor of the class
     * @param x The value that will be assigned to the instance
     */
    public scrabbleFloat(double x){
        this.value = x;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    protected void setValue(double value) {
        this.value = value;
    }

    @Override
    public scrabbleString toScrabString() {
        String s = String.valueOf(value);
        return new scrabbleString(s);
    }

    @Override
    public scrabbleFloat toScrabFloat() {
        return this;
    }


    @Override
    public SNumber sum(SNumber n) {
        return n.sumByFloat(this);
    }

    @Override
    public SNumber subs(SNumber n) {
        return n.subsByFloat(this);
    }

    @Override
    public SNumber mult(SNumber n) {
        return n.multByFloat(this);
    }

    @Override
    public SNumber div(SNumber n) {
        return n.divByFloat(this);
    }


    public scrabbleFloat sumByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() + this.value);
    }

    public scrabbleFloat subsByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() - this.value);
    }

    public scrabbleFloat multByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() * this.value);
    }

    public scrabbleFloat divByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() / this.value);
    }


}
