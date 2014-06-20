package com.nealford.conf.ft.composition;

import java.util.HashSet;
import java.util.Set;

// BEGIN java_prime_beta
public class PrimeBeta extends FactorsBeta {
    public PrimeBeta(int number) {
        super(number);
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<Integer>() {{
            add(1); add(number);}};
        return getFactors().equals(primeSet);
    }

}
// END java_prime_beta
