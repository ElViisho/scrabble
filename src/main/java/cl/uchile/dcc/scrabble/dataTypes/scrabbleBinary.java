package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Binary class. It encapsulates a native Java String
 * that has the value of the instance, composed of only 0s and 1s
 */
public class scrabbleBinary extends AbstractDataType{
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
    }

    @Override
    public scrabbleString toScrabString() {
        return new scrabbleString(value);
    }

    @Override
    public scrabbleInt toScrabInt(){
        if (bitToInt(value.charAt(0)) == 0){
            return new scrabbleInt(positiveBinToInt(value));
        } else {
            return new scrabbleInt(negativeBinaryToInt(value));
        }
    }

    @Override
    public scrabbleFloat toScrabFloat(){
        if (bitToInt(value.charAt(0)) == 0){
            return new scrabbleFloat(positiveBinToInt(value));
        } else {
            return new scrabbleFloat(negativeBinaryToInt(value));
        }
    }

    private int negativeBinaryToInt(String binary){
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i=n, j=0; i>0; i--, j++){
            w += (int) Math.pow(2,j) * (binary.charAt(i) == '1' ? 1: 0);
        }
        return w;
    }

    private int positiveBinToInt(String binary){
        int w = 0;
        for (int i=binary.length()-1, j=0; i>0; i--, j++){
            w += (int) Math.pow(2,j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    private int bitToInt(char bit){
        return bit == '0' ? 0 : 1;
    }

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

    @Override
    public scrabbleBinary toScrabBinary() {
        return this;
    }

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


}
