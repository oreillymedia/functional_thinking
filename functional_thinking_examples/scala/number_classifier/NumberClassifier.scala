package main.scala

// BEGIN Number_Classifier_Scala
object NumberClassifier {
  def isFactor(factor: Int, number: Int) =
    number % factor == 0

  def factors(number: Int) =
    (1 to number) filter (isFactor(_, number))

  def sum(factors : Seq[Int]) =
    factors.foldLeft(0)(_ + _)

  def isPerfect(number: Int) =
    sum(factors(number)) - number == number

  def isAbundant(number: Int) =
    sum(factors(number)) - number > number

  def isDeficient(number: Int) =
    sum(factors(number)) - number < number
}
// END Number_Classifier_Scala