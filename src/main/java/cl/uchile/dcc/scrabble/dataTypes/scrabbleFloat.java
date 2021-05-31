package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Float class. It encapsulates a native Java double
 * that has the value of the instance
 */
public class scrabbleFloat extends AbstractDataType{
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
    public void setValue(double value) {
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



    public scrabbleFloat sumInt(scrabbleInt n){
        return new scrabbleFloat(this.value + n.getValue());
    }

    public scrabbleFloat subsInt(scrabbleInt n){
        return new scrabbleFloat(this.value - n.getValue());
    }

    public scrabbleFloat multInt(scrabbleInt n){
        return new scrabbleFloat(this.value * n.getValue());
    }

    public scrabbleFloat divInt(scrabbleInt n){
        return new scrabbleFloat(this.value / n.getValue());
    }


    public scrabbleFloat sumBinary(scrabbleBinary bin){
        return new scrabbleFloat(this.value + bin.toScrabFloat().getValue());
    }

    public scrabbleFloat subsBinary(scrabbleBinary bin){
        return new scrabbleFloat(this.value - bin.toScrabFloat().getValue());
    }

    public scrabbleFloat multBinary(scrabbleBinary bin){
        return new scrabbleFloat(this.value * bin.toScrabFloat().getValue());
    }

    public scrabbleFloat divBinary(scrabbleBinary bin){
        return new scrabbleFloat(this.value / bin.toScrabFloat().getValue());
    }
}
