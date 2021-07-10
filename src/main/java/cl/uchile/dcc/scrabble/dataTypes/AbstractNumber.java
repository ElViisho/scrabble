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
        return eval.ddAdd(this);
    }

    @Override
    public IdataTypes ddAdd(AbstractNumber abstractNumber) {
        return abstractNumber.sum(this);
    }

    @Override
    public IdataTypes subtract(IdataTypes eval) {
        return eval.ddSub(this);
    }

    @Override
    public IdataTypes ddSub(AbstractNumber abstractNumber) {
        return abstractNumber.subs(this);
    }

    @Override
    public IdataTypes multiplicate(IdataTypes eval) {
        return eval.ddMult(this);
    }

    @Override
    public IdataTypes ddMult(AbstractNumber abstractNumber) {
        return abstractNumber.mult(this);
    }

    @Override
    public IdataTypes divide(IdataTypes eval) {
        return eval.ddDiv(this);
    }

    @Override
    public IdataTypes ddDiv(AbstractNumber abstractNumber) {
        return abstractNumber.div(this);
    }
}
