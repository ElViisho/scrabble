package cl.uchile.dcc.scrabble.dataTypes;

public abstract class AbstractNumber extends AbstractDataType implements SNumber{

    @Override
    public scrabbleFloat sumByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() + this.toScrabFloat().getValue());
    }

    @Override
    public scrabbleFloat subsByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() - this.toScrabFloat().getValue());
    }

    @Override
    public scrabbleFloat multByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() * this.toScrabFloat().getValue());
    }

    @Override
    public scrabbleFloat divByFloat(scrabbleFloat x){
        return new scrabbleFloat(x.getValue() / this.toScrabFloat().getValue());
    }

    @Override
    public scrabbleBinary sumByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() + this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    @Override
    public scrabbleBinary subsByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() - this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    @Override
    public scrabbleBinary multByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() * this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }

    @Override
    public scrabbleBinary divByBinary(scrabbleBinary bin){
        int newValue = bin.toScrabInt().getValue() / this.toScrabInt().getValue();
        scrabbleInt newInt = new scrabbleInt(newValue);
        return newInt.toScrabBinary();
    }
}
