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


    @Override
    public SNumber sum(SNumber n) {
        return n.sumByInt(this);
    }

    @Override
    public SNumber subs(SNumber n) {
        return n.subsByInt(this);
    }

    @Override
    public SNumber mult(SNumber n) {
        return n.multByInt(this);
    }

    @Override
    public SNumber div(SNumber n) {
        return n.divByInt(this);
    }

    @Override
    public SNumber sumByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() + this.value);
    }

    @Override
    public SNumber subsByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() - this.value);
    }

    @Override
    public SNumber multByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() * this.value);
    }

    @Override
    public SNumber divByInt(scrabbleInt n){
        return new scrabbleInt(n.getValue() / this.value);
    }


}
