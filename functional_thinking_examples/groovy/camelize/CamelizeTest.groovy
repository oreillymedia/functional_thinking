package com.nealford.functionalthinking

import com.nealford.functionalthinking.Camelize
import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

class CamelizeTest {

  // BEGIN groovy_camelize_test
  @Test void can_camelize() {
    def expected = [event_map: "eventMap",
        name: "name", test_date: "testDate",
        test_string_with_breaks: "testStringWithBreaks"]
    use(Camelize) {
      expected.each { key, value ->
        assertEquals value, key.camelize
      }
    }
  }
  // END groovy_camelize_test
}
