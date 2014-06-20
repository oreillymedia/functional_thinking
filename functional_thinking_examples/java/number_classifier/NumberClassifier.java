package nealford.ft.numberclassification;

// BEGIN functional_number_classifier
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumberClassifier {

    public static boolean isFactor(final int candidate, final int number) {   //<1> 
        return number % candidate == 0;                                    
    }                                                                      
                                                                           
    public static Set<Integer> factors(final int number) {                    //<2>
        Set<Integer> factors = new HashSet<>();                            
        factors.add(1);                                                    
        factors.add(number);                                               
        for (int i = 2; i < number; i++)                                   
            if (isFactor(i, number))                                       
                factors.add(i);                                            
        return factors;                                                    
    }                                                                      
                                                                           
    public static int aliquotSum(final Collection<Integer> factors) {
        int sum = 0;
        int targetNumber = Collections.max(factors);
        for (int n : factors) {                                               //<3>
            sum += n;
        }
        return sum - targetNumber;
    }
                                                                           
    public static boolean isPerfect(final int number) {                    
        return aliquotSum(factors(number)) == number;
    }                                                                      
                                                                              //<4>
    public static boolean isAbundant(final int number) {
        return aliquotSum(factors(number)) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquotSum(factors(number)) < number;
    }
}
// END functional_number_classifier
