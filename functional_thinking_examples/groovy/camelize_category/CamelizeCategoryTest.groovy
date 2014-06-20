package com.nealford.functionalthinking

import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class CamelizeCategoryTest {
    // BEGIN groovy_camelize_category_test
  @Test void testCamelize() {
    def expected = [event_map: "eventMap",
        name: "name", test_date: "testDate",
        test_string_with_breaks: "testStringWithBreaks"]
    use(CamelizeCategory) {
      expected.each { key, value ->
        assertEquals value, key.camelize()
      }
    }
  }
  // END groovy_camelize_category_test


  @Test(expected = groovy.lang.MissingMethodException)
  void testCannotCamelizeNonString() {
    int i = 12
    use(CamelizeCategory) {
      i.camelize()
    }
  }
}
