package com.nealford.functionalthinking

import org.junit.Test

import static groovy.util.GroovyTestCase.assertEquals

/**
 * (probably) Copyright 2013 by Neal Ford. All rights reserved.
 */
class TestCamelizeExpando {

  // BEGIN groovy_camelize_expando
  static {
    String.metaClass.camelize = {->
      def newName = delegate.split("_").collect() {
        it.substring(0, 1).toUpperCase() +
            it.substring(1, it.length())
      }.join()
      newName.substring(0, 1).toLowerCase() +
          newName.substring(1, newName.length())
    }
  }

  def expected = [event_map: "eventMap",
      name: "name", test_date: "testDate",
      test_string_with_breaks: "testStringWithBreaks"]

  @Test void can_camelize() {
    expected.each { key, value ->
      assertEquals value, key.camelize()
    }
  }
  // END groovy_camelize_expando
}
