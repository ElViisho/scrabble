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
        return new scrabbleString(s);
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
        return new scrabbleBool(!this.value);
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
        return new scrabbleBool(this.value && bool.value);
    }

    /**
     * {@inheritDoc}
     * @param bool the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBool disjBool(scrabbleBool bool){
        return new scrabbleBool(this.value || bool.value);
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the conjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary conjBinary(scrabbleBinary bin){
        if (this.value){
            return new scrabbleBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '0';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    /**
     * {@inheritDoc}
     * @param bin the value with which the disjunction will be made
     * @return the result
     */
    @Override
    public scrabbleBinary disjBinary(scrabbleBinary bin){
        if (!this.value){
            return new scrabbleBinary(bin.getValue());
        }
        int length = bin.getValue().length();
        char newArr[] = new char[length];
        for (int i=0; i<length; i++) {
            newArr[i] = '1';
        }
        return new scrabbleBinary(String.valueOf(newArr));
    }

    @Override
    public IdataTypes negate(){
        return this.negation();
    }

    @Override
    public IdataTypes conjunction(IdataTypes eval) {
        return eval.ddConj(this);
    }

    @Override
    public IdataTypes ddConj(SLogic logic) {
        return logic.conj(this);
    }

    @Override
    public IdataTypes disjunction(IdataTypes eval) {
        return eval.ddDisj(this);
    }

    @Override
    public IdataTypes ddDisj(SLogic logic) {
        return logic.disj(this);
    }

}
