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
        return TypeFactory.createSFloat(x.getValue() + this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's subtracted this
     * @return the result
     */
    @Override
    public scrabbleFloat subsByFloat(scrabbleFloat x){
        return TypeFactory.createSFloat(x.getValue() - this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's multiplying this
     * @return the result
     */
    @Override
    public scrabbleFloat multByFloat(scrabbleFloat x){
        return TypeFactory.createSFloat(x.getValue() * this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param x the number that's dividing this
     * @return the result
     */
    @Override
    public scrabbleFloat divByFloat(scrabbleFloat x){
        return TypeFactory.createSFloat(x.getValue() / this.toScrabFloat().getValue());
    }

    /**
     * {@inheritDoc}
     * @param bin the number that's summing this
     * @return the result
     */
    @Override
    public scrabbleBinary sumByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() + this.toScrabInt().getValue();
        scrabbleInt newInt = TypeFactory.createSInt(newValue);
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
        scrabbleInt newInt = TypeFactory.createSInt(newValue);
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
        scrabbleInt newInt = TypeFactory.createSInt(newValue);
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
        scrabbleInt newInt = TypeFactory.createSInt(newValue);
        return newInt.toScrabBinary();
    }

    /**
     * It calls the double dispatch function ddAdd of eval, so that it doesn't have
     * to know the type of the instance that will be added to this.
     * @param eval the value that will be added to this
     * @return the sum of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes add(IdataTypes eval) {
        return eval.ddAdd(this);
    }

    /**
     * {@inheritDoc}
     * @param n the value that will add this
     * @return the sum
     */
    @Override
    public IdataTypes ddAdd(AbstractNumber n) {
        return n.sum(this);
    }

    /**
     * It calls the double dispatch function ddSub of eval, so that it doesn't have
     * to know the type of the instance that will be subtracted to this.
     * @param eval the value that will be added to this
     * @return the subtraction of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes subtract(IdataTypes eval) {
        return eval.ddSub(this);
    }

    /**
     * {@inheritDoc}
     * @param n the value that will be subtracted from this
     * @return the subtraction
     */
    @Override
    public IdataTypes ddSub(AbstractNumber n) {
        return n.subs(this);
    }

    /**
     * It calls the double dispatch function ddMult of eval, so that it doesn't have
     * to know the type of the instance that will be multiplied to this.
     * @param eval the value that will be added to this
     * @return the multiplication of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes multiply(IdataTypes eval) {
        return eval.ddMult(this);
    }

    /**
     * {@inheritDoc}
     * @param n the value that will be multiplied by this
     * @return the multiplication
     */
    @Override
    public IdataTypes ddMult(AbstractNumber n) {
        return n.mult(this);
    }

    /**
     * It calls the double dispatch function ddDiv of eval, so that it doesn't have
     * to know the type of the instance that will divide this.
     * @param eval the value that will be added to this
     * @return the division of the values, or null if instance is not operable
     */
    @Override
    public IdataTypes divide(IdataTypes eval) {
        return eval.ddDiv(this);
    }

    /**
     * {@inheritDoc}
     * @param n the value that will be divided by this
     * @return the division
     */
    @Override
    public IdataTypes ddDiv(AbstractNumber n) {
        return n.div(this);
    }
}
