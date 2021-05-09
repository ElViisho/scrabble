package cl.uchile.dcc.scrabble.dataTypes;


/**
 * The abstract parent class of the different scrabble data types.
 * It implements the two methods that are common to all classes.
 */
public abstract class AbstractDataType implements IdataTypes{
    protected String stringValue;

    /**
     * The constructor of the abstract class
     * @param stringValue The value that will be assigned to the instance
     */
    protected AbstractDataType(String stringValue) {
        this.stringValue = stringValue;
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
    public String toString(){
        return this.stringValue;
    }

}
