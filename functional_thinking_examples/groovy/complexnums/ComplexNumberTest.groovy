package complexnums

import org.junit.Test
import static org.junit.Assert.assertTrue
import org.junit.Before

class ComplexNumberTest {
  def x, y

  @Before void setup() {
    x = new ComplexNumber(3, 2)
    y = new ComplexNumber(1, 4)
  }

  @Test void plus() {
    def z = x + y;
    assertTrue 3 + 1 == z.real
    assertTrue 2 + 4 == z.imaginary
  }
  
  @Test void multiply() {
    def z = x * y
    assertTrue(-5  == z.real)
    assertTrue 14 == z.imaginary
  }

  @Test void to_string() {
    assertTrue "3+2i" == x.toString()
    assertTrue "4+6i" == (x + y).toString()
    assertTrue "3+0i" == new ComplexNumber(3, 0).toString()
    assertTrue "4-2i" == new ComplexNumber(4, -2).toString()
  }
}
