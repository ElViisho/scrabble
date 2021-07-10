package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;

public abstract class AbstractOperation implements Operation {

    @Override
    public scrabbleString toSString() {
        return this.eval().toScrabString();
    }

    @Override
    public scrabbleBool toBool() {
        return this.eval().toScrabBool();
    }

    @Override
    public scrabbleFloat toFloat() {
        return this.eval().toScrabFloat();
    }

    @Override
    public scrabbleInt toInt() {
        return this.eval().toScrabInt();
    }

    @Override
    public scrabbleBinary toBinary() {
        return this.eval().toScrabBinary();
    }
}
