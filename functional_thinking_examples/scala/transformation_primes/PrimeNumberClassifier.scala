package com.nealford.functionalthinking.transformations

object PrimeNumberClassifier {
  def factors(number: Int) =
    (1 to number) filter (number % _ == 0)

  def sum(factors: Seq[Int]) =
    factors.sum

  def isPrime(number: Int) =
    number == 2 || sum(factors(number)) == number + 1
}