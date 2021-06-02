package cl.uchile.dcc.scrabble.dataTypes;

/**
 * Interface to be implemented by the number classes: int, float, binary
 * It encapsulates the sum, subtraction, multiplication and division
 */
public interface SNumber extends IdataTypes{

    /**
     * Sums the current number with the provided number
     * @param n the number to be summed
     * @return the result
     */
    public SNumber sum(SNumber n);

    /**
     * Subtracts the current number with the provided number
     * @param n the number to be summed
     * @return the result
     */
    public SNumber subs(SNumber n);

    /**
     * Multiplies the current number with the provided number
     * @param n the number to be summed
     * @return the result
     */
    public SNumber mult(SNumber n);

    /**
     * Divides the current number with the provided number
     * @param n the number to be summed
     * @return the result
     */
    public SNumber div(SNumber n);


    /**
     * For double dispatch. This is being summed by int n
     * @param n the number that's summing this
     * @return the result
     */
    public SNumber sumByInt(scrabbleInt n);

    /**
     * For double dispatch. This is being subtracted by int n
     * @param n the number that's subtracting this
     * @return the result
     */
    public SNumber subsByInt(scrabbleInt n);

    /**
     * For double dispatch. This is being multiplied by int n
     * @param n the number that's multiplying this
     * @return the result
     */
    public SNumber multByInt(scrabbleInt n);

    /**
     * For double dispatch. This is being divided by int n
     * @param n the number that's dividing this
     * @return the result
     */
    public SNumber divByInt(scrabbleInt n);


    /**
     * For double dispatch. This is being summed by float x
     * @param x the number that's summing this
     * @return the result
     */
    public SNumber sumByFloat(scrabbleFloat x);

    /**
     * For double dispatch. This is being subtracted by float x
     * @param x the number that's subtracted this
     * @return the result
     */
    public SNumber subsByFloat(scrabbleFloat x);

    /**
     * For double dispatch. This is being multiplied by float x
     * @param x the number that's multiplying this
     * @return the result
     */
    public SNumber multByFloat(scrabbleFloat x);

    /**
     * For double dispatch. This is being divided by float x
     * @param x the number that's dividing this
     * @return the result
     */
    public SNumber divByFloat(scrabbleFloat x);


    /**
     * For double dispatch. This is being summed by float x
     * @param bin the number that's summing this
     * @return the result
     */
    public SNumber sumByBinary(scrabbleBinary bin);

    /**
     * For double dispatch. This is being subtracted by float x
     * @param bin the number that's subtracting this
     * @return the result
     */
    public SNumber subsByBinary(scrabbleBinary bin);

    /**
     * For double dispatch. This is being multiplied by float x
     * @param bin the number that's multiplying this
     * @return the result
     */
    public SNumber multByBinary(scrabbleBinary bin);

    /**
     * For double dispatch. This is being divided by float x
     * @param bin the number that's dividing this
     * @return the result
     */
    public SNumber divByBinary(scrabbleBinary bin);
}
