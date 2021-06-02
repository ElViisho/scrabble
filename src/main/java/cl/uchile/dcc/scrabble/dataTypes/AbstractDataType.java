package cl.uchile.dcc.scrabble.dataTypes;


import java.util.Objects;

/**
 * The abstract parent class of the different scrabble data types.
 * It implements the methods that are common to all classes.
 */
public abstract class AbstractDataType implements IdataTypes{
    protected Object value;

    /**
     * The constructor of the abstract class
     */
    protected AbstractDataType() {
    }

    /**
     * {@inheritDoc}
     * @param obj the object to be compared with
     * @return whether the values are the same
     */
    @Override
    public boolean equals(Object obj){
        if (obj.getClass() == this.getClass()){
            var o = (AbstractDataType) obj;
            return o.value.equals(this.value);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * @return the hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(AbstractDataType.class);
    }

    /**
     * {@inheritDoc}
     * @return The value inside an instance of an object
     *         in the form of a Java String
     */
    @Override
    public String toString(){
        return String.valueOf(value);
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleString toScrabString() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleBool toScrabBool() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleFloat toScrabFloat() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleInt toScrabInt() {
        return null;
    }

    /**
     * {@inheritDoc}
     * @return the transformed instance
     */
    @Override
    public scrabbleBinary toScrabBinary() {
        return null;
    }


    /**
     * {@inheritDoc}
     * @param s the string that will concatenate this
     * @return the concatenated string
     */
    public scrabbleString sumByString(scrabbleString s){
        return new scrabbleString(s.getValue() + this.toString());
    }
}
