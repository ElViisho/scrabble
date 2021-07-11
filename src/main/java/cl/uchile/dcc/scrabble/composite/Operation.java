package cl.uchile.dcc.scrabble.composite;

import cl.uchile.dcc.scrabble.dataTypes.*;

/**
 * The interface for every operation class (Composite node of a tree).
 * It has all the necessary transformations between types
 */
public interface Operation extends Component{

    /**
     * Transform into a scrabbleString
     * @return the transformed value if transformation is valid, or null otherwise
     */
    scrabbleString toSString();

    /**
     * Transform into a scrabbleBool
     * @return the transformed value if transformation is valid, or null otherwise
     */
    scrabbleBool toBool();

    /**
     * Transform into a scrabbleFloat
     * @return the transformed value if transformation is valid, or null otherwise
     */
    scrabbleFloat toFloat();

    /**
     * Transform into a scrabbleInt
     * @return the transformed value if transformation is valid, or null otherwise
     */
    scrabbleInt toInt();

    /**
     * Transform into a scrabbleBinary
     * @return the transformed value if transformation is valid, or null otherwise
     */
    scrabbleBinary toBinary();
}
