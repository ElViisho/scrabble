package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The abstract parent class of the different number classes: int, float, binary.
 * It implements the operations between numbers.
 */
public abstract class AbstractNumber extends AbstractDataType implements SNumber{

    /**
     * {@inheritDoc}
     * @param x the number that's summing this
     * @return the result
     */
    @Override
    public scrabbleFloat sumByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() + this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's subtracted this
     * @return the result
     */
    @Override
    public scrabbleFloat subsByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() - this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's multiplying this
     * @return the result
     */
    @Override
    public scrabbleFloat multByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() * this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's dividing this
     * @return the result
     */
    @Override
    public scrabbleFloat divByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() / this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param bin the number that's summing this
     * @return the result
     */
    @Override
    public scrabbleBinary sumByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() + this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param bin the number that's subtracting this
     * @return the result
     */
    @Override
    public scrabbleBinary subsByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() - this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param bin the number that's multiplying this
     * @return the result
     */
    @Override
    public scrabbleBinary multByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() * this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    /**
     * {@inheritDoc}
     * @param bin the number that's dividing this
     * @return the result
     */
    @Override
    public scrabbleBinary divByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() / this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }


    @Override
    public IdataTypes add(IdataTypes eval) {
        if (eval instanceof SNumber) return this.sum((SNumber) eval);
        else return null;
    }

    @Override
    public IdataTypes subtract(IdataTypes eval) {
        if (eval instanceof SNumber) return this.subs((SNumber) eval);
        else return null;
    }

    @Override
    public IdataTypes multiplicate(IdataTypes eval) {
        if (eval instanceof SNumber) return this.mult((SNumber) eval);
        else return null;
    }

    @Override
    public IdataTypes divide(IdataTypes eval) {
        if (eval instanceof SNumber) return this.div((SNumber) eval);
        else return null;
    }
}
