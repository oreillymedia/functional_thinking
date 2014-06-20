final class Complex(val real: Int, val imaginary: Int) extends Ordered[Complex] {

  def +(operand: Complex) =
      new Complex(real + operand.real, imaginary + operand.imaginary)

  def +(operand: Int) =
    new Complex(real + operand, imaginary)

  def -(operand: Complex) =
    new Complex(real - operand.real, imaginary - operand.imaginary)

  def -(operand: Int) =
    new Complex(real - operand, imaginary)

  def *(operand: Complex) =
      new Complex(real * operand.real - imaginary * operand.imaginary,
          real * operand.imaginary + imaginary * operand.real)

  override def toString() =
      real + (if (imaginary < 0) "" else "+") + imaginary + "i"

  override def equals(that: Any) = that match {
    case other : Complex => (real == other.real) && (imaginary == other.imaginary)
    case other : Int => (real == other) && (imaginary == 0)
    case _ => false
  }

  override def hashCode(): Int =
    41 * ((41 + real) + imaginary)

  def compare(that: Complex) : Int = {
    def myMagnitude = Math.sqrt(real ^ 2 + imaginary ^ 2)
    def thatMagnitude = Math.sqrt(that.real ^ 2 + that.imaginary ^ 2)
    (myMagnitude - thatMagnitude).round.toInt
  }
}