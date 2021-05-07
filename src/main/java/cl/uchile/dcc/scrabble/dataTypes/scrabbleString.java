package cl.uchile.dcc.scrabble.dataTypes;

import java.util.Objects;

public class scrabbleString {
    private String value;

    public scrabbleString(String str){
        this.value = str;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scrabbleString.class);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof scrabbleString){
            var o = (scrabbleString) obj;
            return o.value.equals(this.value);
        }
        return false;
    }
}
