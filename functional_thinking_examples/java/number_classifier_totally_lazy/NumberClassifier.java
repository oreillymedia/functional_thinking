package nealford.ft.totallylazy;

// BEGIN number_classifier_totallylazy

import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Sequence;

import static com.googlecode.totallylazy.Predicates.is;
import static com.googlecode.totallylazy.numbers.Numbers.*;
import static com.googlecode.totallylazy.predicates.WherePredicate.where;

public class NumberClassifier {
    public static Predicate<Number> isFactor(Number n) {
         return where(remainder(n), is(zero));            // <1>
     }

     public static Sequence<Number> getFactors(final Number n) {
         return range(1, n).filter(isFactor(n));
     }

     public static Sequence<Number> factors(final Number n) {
         return getFactors(n).memorise();
     }

     public static Number aliquotSum(Number n) {
         return subtract(factors(n).reduce(sum), n);
     }

     public static boolean isPerfect(Number n) {
         return equalTo(n, aliquotSum(n));
     }

     public static boolean isAbundant(Number n) {
         return greaterThan(aliquotSum(n), n);
     }

     public static boolean isDeficient(Number n) {
         return lessThan(aliquotSum(n), n);
     }}
// END number_classifier_totallylazy
