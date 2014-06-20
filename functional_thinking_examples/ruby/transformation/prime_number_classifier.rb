class PrimeNumberClassifier
  def self.factors(num)
    (1..num).select { |i| num % i == 0 }
  end
    
  def self.sum_factors(num)
    factors(num).reduce(0, :+)
  end

  def self.prime?(num)
    (sum_factors(num) == num + 1)
  end
end
