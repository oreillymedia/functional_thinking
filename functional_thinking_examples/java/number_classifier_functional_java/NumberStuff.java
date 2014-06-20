package com.nealford.functionalthinking.numberclassifier;

import fj.F2;
import fj.data.List;

public class NumberStuff {
    // BEGIN java_foldleft_criteria
    static public int addOnlyOddNumbersIn(List<Integer> numbers) {
        return numbers.foldLeft(new F2<Integer, Integer, Integer>() {
            public Integer f(Integer i1, Integer i2) {
                return (!(i2 % 2 == 0)) ? i1 + i2 : i1;
            }
        }, 0);
    // END java_foldleft_criteria
    }
}
