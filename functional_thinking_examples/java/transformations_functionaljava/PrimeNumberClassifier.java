package com.nealford.ft.imperativeprimes;

import java.util.HashSet;
import java.util.Set;

public class PrimeNumberClassifier {
    private Integer number;

    public PrimeNumberClassifier(int number) {
        this.number = number;
    }

    public boolean isFactor(int potential) {
        return number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<Integer>();
        factors.add(1);
        factors.add(number);
        for (Integer i = 2; i < number; i++)
            if (isFactor(i))
                factors.add(i);
        return factors;
    }

    public int sumFactors() {
        int sum = 0;
        for (int i : getFactors())
            sum += i;
        return sum;
    }

    public boolean isPrime() {
        return sumFactors() == number + 1;
    }
}
