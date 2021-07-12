package cl.uchile.dcc.scrabble.dataTypes;

import java.util.HashMap;

/**
 * The factory class. It is never instantiated, only its methods are called
 * when a new instance wants to be created
 */
public final class TypeFactory {
    private final static HashMap<String, scrabbleBinary> BinaryHashMap = new HashMap<>();
    private final static HashMap<Boolean, scrabbleBool> BoolHashMap = new HashMap<>();
    private final static HashMap<Double, scrabbleFloat> FloatHashMap = new HashMap<>();
    private final static HashMap<Integer, scrabbleInt> IntHashMap = new HashMap<>();
    private final static HashMap<String, scrabbleString> StringHashMap = new HashMap<>();

    /**
     * Private constructor so it won't be instantiated
     */
    private TypeFactory(){
    }

    /**
     * Method for creating a new ScrabbleBinary. It first checks if it already exists
     * on the hash map, and if it does, it returns the one that already exists.
     * Otherwise, it creates a new one and adds it to the hash map
     * @param str the value of the instance
     * @return a scrabbleBinary with the value
     */
    public static scrabbleBinary createSBinary(String str){
        if (BinaryHashMap.containsKey(str)) return BinaryHashMap.get(str);
        scrabbleBinary newBin = new scrabbleBinary(str);
        BinaryHashMap.put(str, newBin);
        return newBin;
    }

    /**
     * Method for creating a new ScrabbleBool. It first checks if it already exists
     * on the hash map, and if it does, it returns the one that already exists.
     * Otherwise, it creates a new one and adds it to the hash map
     * @param bool the value of the instance
     * @return a scrabbleBool with the value
     */
    public static scrabbleBool createSBool(boolean bool){
        if (BoolHashMap.containsKey(bool)) return BoolHashMap.get(bool);
        scrabbleBool newBool = new scrabbleBool(bool);
        BoolHashMap.put(bool, newBool);
        return newBool;
    }

    /**
     * Method for creating a new ScrabbleFloat. It first checks if it already exists
     * on the hash map, and if it does, it returns the one that already exists.
     * Otherwise, it creates a new one and adds it to the hash map
     * @param x the value of the instance
     * @return a scrabbleFloat with the value
     */
    public static scrabbleFloat createSFloat(double x){
        if (FloatHashMap.containsKey(x)) return FloatHashMap.get(x);
        scrabbleFloat newFloat = new scrabbleFloat(x);
        FloatHashMap.put(x, newFloat);
        return newFloat;
    }

    /**
     * Method for creating a new ScrabbleInt. It first checks if it already exists
     * on the hash map, and if it does, it returns the one that already exists.
     * Otherwise, it creates a new one and adds it to the hash map
     * @param n the value of the instance
     * @return a scrabbleInt with the value
     */
    public static scrabbleInt createSInt(int n){
        if (IntHashMap.containsKey(n)) return IntHashMap.get(n);
        scrabbleInt newInt = new scrabbleInt(n);
        IntHashMap.put(n, newInt);
        return newInt;
    }

    /**
     * Method for creating a new ScrabbleString. It first checks if it already exists
     * on the hash map, and if it does, it returns the one that already exists.
     * Otherwise, it creates a new one and adds it to the hash map
     * @param str the value of the instance
     * @return a scrabbleString with the value
     */
    public static scrabbleString createSString(String str){
        if (StringHashMap.containsKey(str)) return StringHashMap.get(str);
        scrabbleString newString = new scrabbleString(str);
        StringHashMap.put(str, newString);
        return newString;
    }

}