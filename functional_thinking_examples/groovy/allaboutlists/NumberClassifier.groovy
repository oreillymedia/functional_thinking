package com.nealford.ft.allaboutlists

import static com.nealford.ft.allaboutlists.NumberClassification.*

def enum NumberClassification {
  PERFECT, ABUNDANT, DEFICIENT
}

class NumberClassifier {
  static def factorsOf(number) {
    (1..number).findAll { i -> number % i == 0 }
  }

  static def classify(number) {
    switch (factorsOf(number).inject(0, { i, j -> i + j })) {
      case { it < 2 * number }: return DEFICIENT
      case { it > 2 * number }: return ABUNDANT
      case { it == 2 * number }: return PERFECT
    }
  }

  static def isPerfect(number) {
    classify(number) == PERFECT
  }


  static def nextPerfectNumberAfter(n) {
    while (!isPerfect(++n));
    n
  }
}
