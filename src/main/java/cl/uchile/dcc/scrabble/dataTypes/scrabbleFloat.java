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
        super.value = this.value;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleString toScrabString() {
        String s = String.valueOf(value);
        return new scrabbleString(s);
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleFloat toScrabFloat() {
        return this;
    }

    /**
     * {@inheritDoc}
     * @param n the number to be summed
     * @return the result
     */
    @Override
    public SNumber sum(SNumber n) {
        return n.sumByFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be subtracted
     * @return the result
     */
    @Override
    public SNumber subs(SNumber n) {
        return n.subsByFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be multiplicated
     * @return the result
     */
    @Override
    public SNumber mult(SNumber n) {
        return n.multByFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be divided
     * @return the result
     */
    @Override
    public SNumber div(SNumber n) {
        return n.divByFloat(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's summing this
     * @return the result
     */
    @Override
    public scrabbleFloat sumByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() + this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's subtracting this
     * @return the result
     */
    @Override
    public scrabbleFloat subsByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() - this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's multiplying this
     * @return the result
     */
    @Override
    public scrabbleFloat multByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() * this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's dividing this
     * @return the result
     */
    @Override
    public scrabbleFloat divByInt(scrabbleInt n){
        return new scrabbleFloat(n.getValue() / this.value);
    }


}
