package com.nealford.numberclassifier


class NumberClassifier {

// BEGIN groovy_filter
  static def factors(number) {
    (1..number).findAll {number % it == 0}
  }
// END groovy_filter

// BEGIN groovy_reduce
  static def sumFactors(number) {
    factors(number).inject(0, {i, j -> i + j})
  }
// END groovy_reduce

  static def isPerfect(number) {
    sumFactors(number) - number == number
  }

  static def isAbundant(number) {
    sumFactors(number) - number > number
  }

  static def isDeficient(number) {
    sumFactors(number) - number < number
  }

}
