package com.nealford.ft.memoization


// Things to note:
//   1. can't do static now because of ripple effect from sumOfFactors
//
// BEGIN groovy_classifier_cached_sum
class ClassifierCachedSum {
  private sumCache = [:]

  def sumOfFactors(number) {
    if (! sumCache.containsKey(number)) {
      sumCache[number] = factorsOf(number).sum()
    }
   return sumCache[number]

  }
// remainder of code unchanged...
// END groovy_classifier_cached_sum

  def isFactor(number, potential) {
    number % potential == 0;
  }

  def factorsOf(number) {
    (1..number).findAll { i -> isFactor(number, i) }
  }

  def isPerfect(number) {
    sumOfFactors(number) == 2 * number
  }

  def isAbundant(number) {
    sumOfFactors(number) > 2 * number
  }

  def isDeficient(number) {
    sumOfFactors(number) < 2 * number
  }
}
