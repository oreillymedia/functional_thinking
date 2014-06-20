package com.nealford.ft.errorhandling;

import fj.P1;
import fj.data.Either;
import fj.data.Option;

public class FjRomanNumeralParser {
    private static final int MIN = 0;
    private static final int MAX = 1000;

    public static Either<Exception, Integer> parseNumber(String s) {
        if (! s.matches("[IVXLXCDM]+"))
            return Either.left(new Exception("Invalid Roman numeral"));
        else
            return Either.right(new RomanNumeral(s).toInt());
    }

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

    public static Either<Exception, Integer> parseNumberDefaults(final String s) {
        if (! s.matches("[IVXLXCDM]+"))
            return Either.left(new Exception("Invalid Roman numeral"));
        else {
            int number = new RomanNumeral(s).toInt();
            return Either.right(new RomanNumeral(number >= MAX ? MAX : number).toInt());
        }
    }

// BEGIN java_fj_divide_exception
public static Either<Exception, Integer> divide(int x, int y) {
    try {
        return Either.right(x / y);
    } catch (Exception e) {
        return Either.left(e);
    }
}
// END java_fj_divide_exception

// BEGIN java_fj_option
public static Option<Double> divide(double x, double y) {
    if (y == 0)
        return Option.none();
    return Option.some(x / y);
}
// END java_fj_option

// BEGIN java_fj_romans_divide_lazy
public static P1<Either<Exception, Integer>> divideLazily(final int x, final int y) {
    return new P1<Either<Exception, Integer>>() {
        public Either<Exception, Integer> _1() {
            try {
                return Either.right(x / y);
            } catch (Exception e) {
                return Either.left(e);
            }
        }
    };
}
// END java_fj_romans_divide_lazy

// BEGIN java_fj_next_exceptions
public static Either<NumberFormatException, Either<ArithmeticException, Double>>
        divideRoman(final String x, final String y) {
    Either<Exception, Integer> possibleX = parseNumber(x);
    Either<Exception, Integer> possibleY = parseNumber(y);
    if (possibleX.isLeft() || possibleY.isLeft())
        return Either.left(new NumberFormatException("invalid parameter"));
    int intY = possibleY.right().value().intValue();
    Either<ArithmeticException, Double> errorForY =
            Either.left(new ArithmeticException("div by 1"));
    if (intY == 1)
        return Either.right((fj.data.Either<ArithmeticException, Double>) errorForY);
    int intX = possibleX.right().value().intValue();
    Either<ArithmeticException, Double> result =
            Either.right(new Double((double) intX) / intY);
    return Either.right(result);
}
// END java_fj_next_exceptions

}
