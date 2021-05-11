package cl.uchile.dcc.scrabble.dataTypes;


import java.util.Objects;

/**
 * The abstract parent class of the different scrabble data types.
 * It implements the two methods that are common to all classes.
 */
public abstract class AbstractDataType implements IdataTypes{
    protected Object value;

    /**
     * The constructor of the abstract class
     */
    protected AbstractDataType() {
    }

    @Override
    public boolean equals(Object obj){
        if (obj.getClass() == this.getClass()){
            var o = (AbstractDataType) obj;
            return o.value.equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(AbstractDataType.class);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public scrabbleString toScrabString() {
        return null;
    }

    @Override
    public scrabbleBool toScrabBool() {
        return null;
    }

    @Override
    public scrabbleFloat toScrabFloat() {
        return null;
    }

    @Override
    public scrabbleInt toScrabInt() {
        return null;
    }

    @Override
    public scrabbleBinary toScrabBinary() {
        return null;
    }
}
