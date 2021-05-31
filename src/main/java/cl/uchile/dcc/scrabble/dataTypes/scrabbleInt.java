package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Int class. It encapsulates a native Java int
 * that has the value of the instance
 */
public class scrabbleInt extends AbstractDataType{
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
    public void setValue(int value) {
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


    public scrabbleFloat sumFloat(scrabbleFloat x){
        return new scrabbleFloat(this.value + x.getValue());
    }

    public scrabbleFloat subsFloat(scrabbleFloat x){
        return new scrabbleFloat(this.value - x.getValue());
    }

    public scrabbleFloat multFloat(scrabbleFloat x){
        return new scrabbleFloat(this.value * x.getValue());
    }

    public scrabbleFloat divFloat(scrabbleFloat x){
        return new scrabbleFloat(this.value / x.getValue());
    }



    public scrabbleInt sumInt(scrabbleInt n){
        return new scrabbleInt(this.value + n.getValue());
    }

    public scrabbleInt subsInt(scrabbleInt n){
        return new scrabbleInt(this.value - n.getValue());
    }

    public scrabbleInt multInt(scrabbleInt n){
        return new scrabbleInt(this.value * n.getValue());
    }

    public scrabbleInt divInt(scrabbleInt n){
        return new scrabbleInt(this.value / n.getValue());
    }



    public scrabbleInt sumBinary(scrabbleBinary bin){
        return new scrabbleInt(this.value + bin.toScrabInt().getValue());
    }

    public scrabbleInt subsBinary(scrabbleBinary bin){
        return new scrabbleInt(this.value - bin.toScrabInt().getValue());
    }

    public scrabbleInt multBinary(scrabbleBinary bin){
        return new scrabbleInt(this.value * bin.toScrabInt().getValue());
    }

    public scrabbleInt divBinary(scrabbleBinary bin){
        return new scrabbleInt(this.value / bin.toScrabInt().getValue());
    }
}
