package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;

public interface Operation extends Component{

    scrabbleString toSString();

    scrabbleBool toBool();

    scrabbleFloat toFloat();

    scrabbleInt toInt();

    scrabbleBinary toBinary();
}
