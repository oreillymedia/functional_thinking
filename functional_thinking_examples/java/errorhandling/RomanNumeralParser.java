package com.nealford.ft.errorhandling;

import fj.P1;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralParser {
// BEGIN java_romans_default
private static final int MIN = 0;
private static final int MAX = 1000;

    public static Either<Exception, Integer> parseNumberDefaults(final String s) {
    if (! s.matches("[IVXLXCDM]+"))
        return Either.left(new Exception("Invalid Roman numeral"));
    else {
        int number = new RomanNumeral(s).toInt();
        return Either.right(new RomanNumeral(number >= MAX ? MAX : number).toInt());
    }
}
// END java_romans_default

// BEGIN java_romans_parse
public static Either<Exception, Integer> parseNumber(String s) {
    if (! s.matches("[IVXLXCDM]+"))
        return Either.left(new Exception("Invalid Roman numeral"));
    else
        return Either.right(new RomanNumeral(s).toInt());
}
// END java_romans_parse

// BEGIN java_romans_lazy
public static P1<Either<Exception, Integer>> parseNumberLazy(final String s) {
    if (! s.matches("[IVXLXCDM]+"))
        return new P1<Either<Exception, Integer>>() {
            public Either<Exception, Integer> _1() {
                return Either.left(new Exception("Invalid Roman numeral"));
            }
        };
    else
        return new P1<Either<Exception, Integer>>() {
            public Either<Exception, Integer> _1() {
                return Either.right(new RomanNumeral(s).toInt());
            }
        };
}
// END java_romans_lazy


// BEGIN java_romannum_divide
public static Map<String, Object> divide(int x, int y) {
    Map<String, Object> result = new HashMap<String, Object>();
    if (y == 0)
        result.put("exception", new Exception("div by zero"));
    else
        result.put("answer", (double) x / y);
    return result;
}
// END java_romannum_divide
}
