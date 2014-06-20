import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertTrue

/**
 * (probably) Copyright 2013 by Neal Ford. All rights reserved.
 */
class IntegerConv {
  static Double getAsMeters(Integer self) {
    self * 0.30480
  }

  static Double getAsFeet(Integer self) {
    self * 3.2808
  }
}

// BEGIN groovy_integer_conv_test
class IntegerConvTest{

  static {
    Integer.metaClass.getAsM { ->
      delegate * 0.30480
    }

    Integer.metaClass.getAsFt { ->
      delegate * 3.2808
    }

  }


  @Test void test_conversion_with_expando() {
    assertTrue 1.asM == 0.30480
    assertTrue 1.asFt == 3.2808
  }

  @Test void test_conversion_with_category() {
    use(IntegerConv) {
      assertEquals(1 * 3.2808, 1.asFeet, 0.1)
      assertEquals(1 * 0.30480, 1.asMeters, 0.1)
    }
  }
// END groovy_integer_conv_test

  @Test void expando_order() {
    try {
      1.decode()
    } catch(NullPointerException ex) {
      println("can't decode with no parameters")
    }
    Integer.metaClass.decode { ->
      delegate * Math.PI;
    }
    assertEquals(1.decode(), Math.PI, 0.1)
  }
}
