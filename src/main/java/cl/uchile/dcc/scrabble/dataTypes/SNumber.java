package cl.uchile.dcc.scrabble.dataTypes;

public interface SNumber {
    public SNumber sum(SNumber n);
    public SNumber subs(SNumber n);
    public SNumber mult(SNumber n);
    public SNumber div(SNumber n);
    public SNumber sumByInt(scrabbleInt n);
    public SNumber subsByInt(scrabbleInt n);
    public SNumber multByInt(scrabbleInt n);
    public SNumber divByInt(scrabbleInt n);
    public SNumber sumByFloat(scrabbleFloat x);
    public SNumber subsByFloat(scrabbleFloat x);
    public SNumber multByFloat(scrabbleFloat x);
    public SNumber divByFloat(scrabbleFloat x);
    public SNumber sumByBinary(scrabbleBinary bin);
    public SNumber subsByBinary(scrabbleBinary bin);
    public SNumber multByBinary(scrabbleBinary bin);
    public SNumber divByBinary(scrabbleBinary bin);
}
