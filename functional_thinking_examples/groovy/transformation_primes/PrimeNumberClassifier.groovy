package com.nealford.functionalthinking.transformations

class PrimeNumberClassifier {
  private int number;

  PrimeNumberClassifier(int number) {
    this.number = number
  }

  public def getFactors() {
    (1..number).findAll { number % it == 0 }.toSet()
  }

  public def sumFactors() {
    getFactors().sum()
  }

  public def isPrime() {
    sumFactors() == number + 1
  }

}
