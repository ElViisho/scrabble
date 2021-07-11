package cl.uchile.dcc.scrabble.dataTypes;

import static java.lang.Math.max;

/**
 * The Scrabble Binary class. It encapsulates a native Java String
 * that has the value of the instance, composed of only 0s and 1s
 */
public class scrabbleBinary extends AbstractNumber implements SLogic{
    private String value;

    /**
     * The constructor of the class
     * @param str The value that will be assigned to the instance
     */
    public scrabbleBinary(String str) {
        this.value = str;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    protected void setValue(String value) {
        this.value = value;
        super.value = this.value;
    }

    /**
     * {@inheritDoc}
     * @param obj the object to be compared with
     * @return wether the values are the same
     */
    @Override
    public boolean equals(Object obj){
        if (obj.getClass() == this.getClass()){
            var o = (scrabbleBinary) obj;
            String s1 = o.value;
            String s2 = this.value;
            while (s1.length() > 1 && ((s1.charAt(0)=='0' && s1.charAt(1)=='0') || (s1.charAt(0)=='1' && s1.charAt(1)=='1'))){
                s1 = s1.substring(1);
            }
            while (s2.length() > 1 && ((s2.charAt(0)=='0' && s2.charAt(1)=='0') || (s2.charAt(0)=='1' && s2.charAt(1)=='1'))){
                s2 = s2.substring(1);
            }
            return s1.equals(s2);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleString toScrabString() {
        return new scrabbleString(value);
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleInt toScrabInt(){
        if (bitToInt(value.charAt(0)) == 0){
            return new scrabbleInt(positiveBinToInt(value));
        } else {
            return new scrabbleInt(negativeBinaryToInt(value));
        }
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleFloat toScrabFloat(){
        if (bitToInt(value.charAt(0)) == 0){
            return new scrabbleFloat(positiveBinToInt(value));
        } else {
            return new scrabbleFloat(negativeBinaryToInt(value));
        }
    }

    /**
     * Transforms a negative binary to an int
     * @param binary the binary to be transformed
     * @return the int
     */
    private int negativeBinaryToInt(String binary){
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i=n, j=0; i>0; i--, j++){
            w += (int) Math.pow(2,j) * (binary.charAt(i) == '1' ? 1: 0);
        }
        return w;
    }

    /**
     * Transforms a positive binary to an int
     * @param binary the binary to be transformed
     * @return the int
     */
    private int positiveBinToInt(String binary){
        int w = 0;
        for (int i=binary.length()-1, j=0; i>0; i--, j++){
            w += (int) Math.pow(2,j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Transforms a char bit into an int
     * @param bit the bit to be transformed
     * @return the int
     */
    private int bitToInt(char bit){
        return bit == '0' ? 0 : 1;
    }

    /**
     * Calculates the two's complement of a binary
     * @return the complement
     */
    public scrabbleBinary twosComplement(){
        scrabbleBinary negated = this.negation();
        int length = negated.getValue().length();
        char newArr[] = new char[length];
        int summed = 0;
        for (int i=length-1; i>=0; i--){
            char n = negated.getValue().charAt(i);
            if (summed == 0) {
                if (n == '1') newArr[i] = '0';
                else {
                    newArr[i] = '1';
                    summed = 1;
                }
            }
            else {
                newArr[i] = n;
            }
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleBinary toScrabBinary() {
        return this;
    }

    /**
     * {@inheritDoc}
     * @param l the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public SLogic conj(SLogic l) {
        return l.conjBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param l the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public SLogic disj(SLogic l) {
        return l.disjBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary conjBinary(scrabbleBinary bin) {
        String value1 = this.getValue();
        String value2 = bin.getValue();
        int largo1 = value1.length();
        int largo2 = value2.length();
        int largo = max(largo1, largo2);
        while (value1.length() < largo){
            value1 = '0' + value1;
        }
        while (value2.length() < largo){
            value2 = '0' + value2;
        }
        char arr[] = new char[largo];
        for (int i=0; i<largo; i++){
            arr[i] = (value1.charAt(i) == '1' && value2.charAt(i) == '1') ? '1' : '0';
        }
        String s = String.valueOf(arr);
        return new scrabbleBinary(s);
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary disjBinary(scrabbleBinary bin) {
        String value1 = this.getValue();
        String value2 = bin.getValue();
        int largo1 = value1.length();
        int largo2 = value2.length();
        int largo = max(largo1, largo2);
        while (value1.length() < largo){
            value1 = '0' + value1;
        }
        while (value2.length() < largo){
            value2 = '0' + value2;
        }
        char arr[] = new char[largo];
        for (int i=0; i<largo; i++){
            arr[i] = (value1.charAt(i) == '1' || value2.charAt(i) == '1') ? '1' : '0';
        }
        String s = String.valueOf(arr);
        return new scrabbleBinary(s);
    }

    /**
     * {@inheritDoc}
     * @return the new value
     */
    @Override
    public scrabbleBinary negation(){
        int length = this.value.length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            char n = this.value.charAt(i);
            if (n == '1') newArr[i] = '0';
            else newArr[i] = '1';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    /**
     * {@inheritDoc}
     * @param bool the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary conjBool(scrabbleBool bool){
        if (bool.getValue()) {
            return new scrabbleBinary(this.value);
        }
        int length = this.value.length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '0';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    /**
     * {@inheritDoc}
     * @param bool the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary disjBool(scrabbleBool bool){
        if (!bool.getValue()) {
            return new scrabbleBinary(this.value);
        }
        int length = this.value.length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '1';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }


    /**
     * {@inheritDoc}
     * @param n the number to be summed
     * @return the result
     */
    @Override
    public SNumber sum(SNumber n) {
        return n.sumByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be subtracted
     * @return the result
     */
    @Override
    public SNumber subs(SNumber n) {
        return n.subsByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be multiplied
     * @return the result
     */
    @Override
    public SNumber mult(SNumber n) {
        return n.multByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number to be divided
     * @return the result
     */
    @Override
    public SNumber div(SNumber n) {
        return n.divByBinary(this);
    }

    /**
     * {@inheritDoc}
     * @param n the number that's summing this
     * @return the result
     */
    @Override
    public scrabbleInt sumByInt(scrabbleInt n) {
        return new scrabbleInt(n.getValue() + this.toScrabInt().getValue());
    }

    /**
     * {@inheritDoc}
     * @param n the number that's subtracting this
     * @return the result
     */
    @Override
    public scrabbleInt subsByInt(scrabbleInt n) {
        return new scrabbleInt(n.getValue() - this.toScrabInt().getValue());
    }

    /**
     * {@inheritDoc}
     * @param n the number that's multiplying this
     * @return the result
     */
    @Override
    public scrabbleInt multByInt(scrabbleInt n) {
        return new scrabbleInt(n.getValue() * this.toScrabInt().getValue());
    }

    /**
     * {@inheritDoc}
     * @param n the number that's dividing this
     * @return the result
     */
    @Override
    public scrabbleInt divByInt(scrabbleInt n) {
        return new scrabbleInt(n.getValue() / this.toScrabInt().getValue());
    }

    /**
     * {@inheritDoc}
     * @return the negated value
     */
    @Override
    public IdataTypes negate(){
        return this.negation();
    }

    /**
     * It calls the double dispatch function ddConj of eval, so that it doesn't have
     * to know the type of the instance that will be evaluated with this.
     * @param eval the value that will be evaluated with this
     * @return the conjunction of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes conjunction(IdataTypes eval) {
        return eval.ddConj(this);
    }

    /**
     * {@inheritDoc}
     * @param logic the value that will be evaluated with this
     * @return the conjunction
     */
    @Override
    public IdataTypes ddConj(SLogic logic) {
        return logic.conj(this);
    }

    /**
     * It calls the double dispatch function ddDisj of eval, so that it doesn't have
     * to know the type of the instance that will be evaluated with this.
     * @param eval the value that will be evaluated with this
     * @return the disjunction of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes disjunction(IdataTypes eval) {
        return eval.ddDisj(this);
    }

    /**
     * {@inheritDoc}
     * @param logic the value that will be evaluated with this
     * @return the disjunction
     */
    @Override
    public IdataTypes ddDisj(SLogic logic) {
        return logic.disj(this);
    }
}
