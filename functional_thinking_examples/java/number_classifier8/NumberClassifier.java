package com.nealford.ft.nc8;

// BEGIN number_classifier_java8
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class NumberClassifier {

    // BEGIN java8_filter
    public static IntStream factorsOf(int number) {
        return range(1, number + 1)
                .filter(potential -> number % potential == 0);
    }
    // END java8_filter

    public static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static boolean isPerfect(int number) {
        return aliquotSum(number) == number;
    }

    public static boolean isAbundant(int number) {
        return aliquotSum(number)> number;
    }

    public static boolean isDeficient(int number) {
        return aliquotSum(number) < number;
    }

}
// END number_classifier_java8

    // BEGIN java8_filter_fast
    //    public static List fastFactorsOf(int number) {
    //        List<Integer> factors = range(1, (int) (sqrt(number) + 1))
    //                .filter(potential -> number % potential == 0)
    //                .boxed()
    //                .collect(toList());
    //        List factorsAboveSqrt = factors
    //                .stream()
    //                .map(e -> number / e).collect(toList());
    //        factors.addAll(factorsAboveSqrt);
    //        return factors.stream().distinct().collect(toList());
    //    }
    // END java8_filter_fast




