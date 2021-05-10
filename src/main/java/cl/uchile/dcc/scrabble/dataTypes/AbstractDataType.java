package cl.uchile.dcc.scrabble.dataTypes;


import java.util.Objects;

/**
 * The abstract parent class of the different scrabble data types.
 * It implements the two methods that are common to all classes.
 */
public abstract class AbstractDataType implements IdataTypes{
    protected String stringValue;

    /**
     * The constructor of the abstract class
     */
    protected AbstractDataType(String str) {
        this.stringValue = str;
    }

    @Override
    public boolean equals(Object obj){
        if (obj.getClass() == this.getClass()){
            var o = (AbstractDataType) obj;
            return o.stringValue.equals(this.stringValue);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(AbstractDataType.class);
    }

    @Override
    public String toString(){
        return this.stringValue;
    }

    public scrabbleBool toBool() {
        return null;
    }

    public scrabbleFloat toFloat() {
        return null;
    }

    public scrabbleInt toInt() {
        return null;
    }

    public scrabbleBinary toBinary() {
        return null;
    }
}
