package cl.uchile.dcc.scrabble.dataTypes;

import static java.lang.Math.abs;

/**
 * The Scrabble Int class. It encapsulates a native Java int
 * that has the value of the instance
 */
public class scrabbleInt extends AbstractNumber {
    private int value;

    /**
     * The constructor of the class
     * @param n The value that will be assigned to the instance
     */
    public scrabbleInt(int n){
        this.value = n;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    protected void setValue(int value) {
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
        return new scrabbleFloat(value);
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleInt toScrabInt() {
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleBinary toScrabBinary(){
        int intValue = abs(value);
        String strValue = "";
        while (intValue > 0){
            int resto = intValue % 2;
            strValue = resto + strValue;
            intValue = intValue /2;
        }
        scrabbleBinary binValue = new scrabbleBinary(strValue);
        if (value < 0) {
            strValue = binValue.twosComplement().getValue();
            while (strValue.length() < 32) {
                strValue = '1' + strValue;
            }
            binValue = new scrabbleBinary(strValue);
        }
        else{
            strValue = '0' + binValue.getValue();
            binValue = new scrabbleBinary(strValue);
        }
        return binValue;
    }

    /**
     * {@inheritDoc}
     * @param n the number to be summed
     * @return the result
     */
    @Override
    public SNumber sum(SNumber n) {
        return n.sumByInt(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be subtracted
     * @return the result
     */
    @Override
    public SNumber subs(SNumber n) {
        return n.subsByInt(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be multiplied
     * @return the result
     */
    @Override
    public SNumber mult(SNumber n) {
        return n.multByInt(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be divided
     * @return the result
     */
    @Override
    public SNumber div(SNumber n) {
        return n.divByInt(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's summing this
     * @return the result
     */
    @Override
    public SNumber sumByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() + this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's subtracting this
     * @return the result
     */
    @Override
    public SNumber subsByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() - this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's multiplying this
     * @return the result
     */
    @Override
    public SNumber multByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() * this.value);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's dividing this
     * @return the result
     */
    @Override
    public SNumber divByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() / this.value);
    }


}
