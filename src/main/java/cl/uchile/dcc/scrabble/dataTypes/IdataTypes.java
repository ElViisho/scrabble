package cl.uchile.dcc.scrabble.dataTypes;

import cl.uchile.dcc.scrabble.composite.Component;

/**
 * Interface to be implemented by the abstract Scrabble data type class
 */
public interface IdataTypes extends Component {
    /**
     * Compares the values of the current instance with another object's
     * to see if they're equal
     * @param obj the object to be compared with
     * @return whether the values are the same
     */
    @Override
    boolean equals(Object obj);

    /**
     * @return the hash code of the object
     */
    @Override
    int hashCode();

    /**
     * @return The value inside an instance of an object
     *         in the form of a Java String
     */
    @Override
    String toString();

    /**
     * Transforms the current instance to a scrabble String instance
     * @return the transformed instance
     */
    scrabbleString toScrabString();

    /**
     * Transforms the current instance to a scrabble Bool instance
     * @return the transformed instance
     */
    scrabbleBool toScrabBool();

    /**
     * Transforms the current instance to a scrabble Float instance
     * @return the transformed instance
     */
    scrabbleFloat toScrabFloat();

    /**
     * Transforms the current instance to a scrabble Int instance
     * @return the transformed instance
     */
    scrabbleInt toScrabInt();

    /**
     * Transforms the current instance to a scrabble Binary instance
     * @return the transformed instance
     */
    scrabbleBinary toScrabBinary();

    /**
     * For using double dispatch. This will be concatenated at the end of s
     * @param s the string that will concatenate this
     * @return the concatenated string
     */
    scrabbleString sumByString(scrabbleString s);


    /**
     * The function that's called by the Add class when being evaluated
     * @param eval the value that will be added to this
     * @return the sum of the values
     */
    IdataTypes add(IdataTypes eval);

    /**
     * The function that's called by the Sub class when being evaluated
     * @param eval the value that will be subtracted to this
     * @return the subtraction of the values
     */
    IdataTypes subtract(IdataTypes eval);

    /**
     * The function that's called by the Mult class when being evaluated
     * @param eval the value that will be multiplied to this
     * @return the multiplication of the values
     */
    IdataTypes multiply(IdataTypes eval);

    /**
     * The function that's called by the Div class when being evaluated
     * @param eval the value that will divide this
     * @return the sum of the values
     */
    IdataTypes divide(IdataTypes eval);

    /**
     * The function that's called by the Negation class when being evaluated
     * @return the negation of this
     */
    IdataTypes negate();

    /**
     * The function that's called by the Conjunction class when being evaluated
     * @param eval the value that will be evaluated with this
     * @return the conjunction of the values
     */
    IdataTypes conjunction(IdataTypes eval);

    /**
     * The function that's called by the Disjunction class when being evaluated
     * @param eval the value that will be evaluated with this
     * @return the disjunction of the values
     */
    IdataTypes disjunction(IdataTypes eval);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be added by n
     * @param n the value that will add this
     * @return the sum
     */
    IdataTypes ddAdd(AbstractNumber n);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be subtracted from n
     * @param n the value that will be subtracted from this
     * @return the subtraction
     */
    IdataTypes ddSub(AbstractNumber n);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be multiplied by n
     * @param n the value that will be multiplied by this
     * @return the multiplication
     */
    IdataTypes ddMult(AbstractNumber n);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be divided by n
     * @param n the value that will be divided by this
     * @return the division
     */
    IdataTypes ddDiv(AbstractNumber n);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be evaluated with logic
     * @param logic the value that will be evaluated with this
     * @return the conjunction
     */
    IdataTypes ddConj(SLogic logic);

    /**
     * For using double dispatch in the composite pattern, so the class
     * doesn't have to ask the type of the other. This will be evaluated with logic
     * @param logic the value that will be evaluated with this
     * @return the disjunction
     */
    IdataTypes ddDisj(SLogic logic);
}
