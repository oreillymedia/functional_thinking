import org.junit.Test

import com.nealford.ft.polydispatch.Multiply

import static org.junit.Assert.assertEquals
import com.nealford.ft.polydispatch.Incrementation

import static org.junit.Assert.assertTrue

import com.nealford.ft.polydispatch.ProductFactory;

class ProductTest {
  @Test
  public void mutiplyTest() {
    def p = new Multiply()
    assertEquals(20, p.evaluate(5, 4));
  }

  @Test
  public void incrementTest() {
    def p = new Incrementation()
    assertEquals(20, p.evaluate(4, 5))
  }

// BEGIN groovy_decisionTest
@Test
public void decisionTest() {
  def p = ProductFactory.getProduct(10010)
  assertTrue p.getClass() == Multiply.class
  assertEquals(2*10010, p.evaluate(2, 10010))
  p = ProductFactory.getProduct(9000)
  assertTrue p.getClass() == Incrementation.class
  assertEquals(3*3000, p.evaluate(3, 3000))
}
// END groovy_decisionTest
}
