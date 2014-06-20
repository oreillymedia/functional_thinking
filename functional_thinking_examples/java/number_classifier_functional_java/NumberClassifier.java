package com.nealford.functionalthinking.numberclassifier;

// BEGIN number_classifier_functional_java
import fj.F;
import fj.data.List;
import static fj.data.List.range;

public class NumberClassifier {

    // BEGIN functional_java_filter
    public List<Integer> factorsOf(final int number) {
        return range(1, number + 1)                                // <1>
                .filter(new F<Integer, Boolean>() {
                    public Boolean f(final Integer i) {
                        return number % i == 0;
                    }
                });                                                // <2>
    }
    // END functional_java_filter

    // BEGIN functional_java_fold
    public int aliquotSum(List<Integer> factors) {                // <3>
        return factors.foldLeft(fj.function.Integers.add, 0) - factors.last();
    }
    // END functional_java_fold

    public boolean isPerfect(int number) {
        return aliquotSum(factorsOf(number)) == number;
    }

    public boolean isAbundant(int number) {
        return aliquotSum(factorsOf(number)) > number;
    }

    public boolean isDeficient(int number) {
        return aliquotSum(factorsOf(number)) < number;
    }
}
// END number_classifier_functional_java
