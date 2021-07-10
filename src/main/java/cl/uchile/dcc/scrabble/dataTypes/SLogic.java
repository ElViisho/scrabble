package cl.uchile.dcc.scrabble.dataTypes;

public interface SLogic extends IdataTypes{
    /**
     * Boolean: changes true to false, and false to true
     * Binary: changes all 1s to 0s, and 0s to 1s
     * @return the new value
     */
    public SLogic negation();


    /**
     * Logic conjunction between two values. For binaries each individual bit is evaluated
     * @param l the value with which the conjunction will be made
     * @return the result
     */
    public SLogic conj(SLogic l);

    /**
     * Logic disjunction between two values. For binaries each individual bit is evaluated
     * @param l the value with which the disjunction will be made
     * @return the result
     */
    public SLogic disj(SLogic l);


    /**
     * For double dispatch. This is being called to do a conjunction by bin
     * @param bin the value with which the conjunction will be made
     * @return the result
     */
    public scrabbleBinary conjBinary(scrabbleBinary bin);

    /**
     * For double dispatch. This is being called to do a disjunction by bin
     * @param bin the value with which the disjunction will be made
     * @return the result
     */
    public scrabbleBinary disjBinary(scrabbleBinary bin);


    /**
     * For double dispatch. This is being called to do a conjunction by bool
     * @param bool the value with which the conjunction will be made
     * @return the result
     */
    public SLogic conjBool(scrabbleBool bool);

    /**
     * For double dispatch. This is being called to do a disjunction by bool
     * @param bool the value with which the disjunction will be made
     * @return the result
     */
    public SLogic disjBool(scrabbleBool bool);

}
