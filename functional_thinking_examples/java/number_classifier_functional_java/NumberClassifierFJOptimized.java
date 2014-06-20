package com.nealford.functionalthinking.numberclassifier;

// BEGIN number_classifier_functional_java_optimized
import static fj.function.Integers.add;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import fj.F;
import fj.data.List;
import static fj.data.List.range;

public class NumberClassifierFJOptimized {

    // BEGIN functional_java_factors_opt
    public static List<Integer> factorsOf(final int number) {
        final List<Integer> factors = range(1, (int) round(sqrt(number) + 1))
                .filter(new F<Integer, Boolean>() {
                    public Boolean f(final Integer i) {
                        return number % i == 0;
                    }
                });
        return factors.append(factors.map(new F<Integer, Integer>() {
            public Integer f(final Integer i) {
                return number / i;
            }
        })).nub();
    }
    // END functional_java_factors_opt

    public static int aliquotSum(List<Integer> factors) {
        return factors.foldLeft(add, 0) - factors.last();
    }

    public static boolean isPerfect(int number) {
        return aliquotSum(factorsOf(number)) == number;
    }

    public static boolean isAbundant(int number) {
        return aliquotSum(factorsOf(number)) > number;
    }

    public static boolean isDeficient(int number) {
        return aliquotSum(factorsOf(number)) < number;
    }
}
// END number_classifier_functional_java_optimized
