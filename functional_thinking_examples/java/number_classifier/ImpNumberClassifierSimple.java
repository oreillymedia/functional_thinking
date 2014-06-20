package nealford.ft.numberclassification;

// BEGIN imp_classifier
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImpNumberClassifierSimple {
    private int _number;                          //<1>
    private Map<Integer, Integer> _cache;         //<2>

    public ImpNumberClassifierSimple(int targetNumber) {
      _number = targetNumber;
      _cache = new HashMap<>();
    }

    public boolean isFactor(int potential) {
      return _number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i < _number; i++)
            if (isFactor(i))
                factors.add(i);
        return factors;
    }

    public int aliquotSum() {                     // <3>
        if (_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors())
                sum += i;
            _cache.put(_number, sum - _number);
        }
        return _cache.get(_number);
    }

    public boolean isPerfect() {
        return aliquotSum() == _number;
    }

    public boolean isAbundant() {
        return aliquotSum() > _number;
    }

    public boolean isDeficient() {
        return aliquotSum() < _number;
    }
}
// END imp_classifier
