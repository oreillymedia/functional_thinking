package com.nealford.conf.ft.composition;

import java.util.Set;

// BEGIN java_fprime
public class FPrime {

    public static boolean isPrime(int number) {
        Set<Integer> factors = Factors.of(number);
        return number > 1 &&
                factors.size() == 2 &&
                factors.contains(1) &&
                factors.contains(number);
    }
}
// END java_fprime
