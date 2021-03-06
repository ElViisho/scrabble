package cl.uchile.dcc.scrabble.dataTypes;

/**
 * The Scrabble Bool type. It encapsulates a native Java boolean
 * that has the value of the instance
 */
public class scrabbleBool extends AbstractDataType implements SLogic{
    private boolean value;

    /**
     * The constructor of the class
     * @param bool The value that will be assigned to the instance
     */
    public scrabbleBool(boolean bool) {
        this.value = bool;
        super.value = this.value;
    }

    /**
     * @return the value of the instance
     */
    public boolean getValue(){
        return value;
    }

    /**
     * @param value The new value that the instance will have
     */
    protected void setValue(boolean value) {
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
        return TypeFactory.createSString(s);
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleBool toScrabBool(){
        return this;
    }

    /**
     * {@inheritDoc}
     * @return the new value
     */
    @Override
    public scrabbleBool negation(){
        return TypeFactory.createSBool(!this.value);
    }

    /**
     * {@inheritDoc}
     * @param l the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public SLogic conj(SLogic l) {
        return l.conjBool(this);
    }

    /**
     * {@inheritDoc}
     * @param l the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public SLogic disj(SLogic l) {
        return l.disjBool(this);
    }

    /**
     * {@inheritDoc}
     * @param bool the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBool conjBool(scrabbleBool bool){
        return TypeFactory.createSBool(this.value && bool.value);
    }

    /**
     * {@inheritDoc}
     * @param bool the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBool disjBool(scrabbleBool bool){
        return TypeFactory.createSBool(this.value || bool.value);
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary conjBinary(scrabbleBinary bin){
        if (this.value){
            return TypeFactory.createSBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '0';
        }
        return TypeFactory.createSBinary(String.valueOf(newArr));
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary disjBinary(scrabbleBinary bin){
        if (!this.value){
            return TypeFactory.createSBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '1';
        }
        return TypeFactory.createSBinary(String.valueOf(newArr));
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
