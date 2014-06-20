import org.scalatest.FunSuite

class ComplexTest extends FunSuite {

  def fixture =
    new {
      val a = new Complex(1, 2)
      val b = new Complex(30, 40)
    }

  test("plus") {
    val f = fixture
    val z = f.a + f.b
    assert(1 + 30 == z.real)
  }

  test("comparison") {
    val f = fixture
    assert(f.a < f.b)
    assert(new Complex(1, 2) >= new Complex(3, 4))
    assert(new Complex(1, 1) < new Complex(2,2))
    assert(new Complex(-10, -10) > new Complex(1, 1))
    assert(new Complex(1, 2) >= new Complex(1, 2))
    assert(new Complex(1, 2) <= new Complex(1, 2))
  }

}