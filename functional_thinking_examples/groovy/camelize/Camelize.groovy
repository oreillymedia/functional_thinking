package com.nealford.functionalthinking

// BEGIN groovy_camelize_category
@Category(String) class Camelize {
  def getCamelize() {
    def cString = this.split("_").collect() { s ->
      s.substring(0, 1).toUpperCase() +
          s.substring(1, s.length())
    }.join()
    cString.substring(0, 1).toLowerCase() +
        cString.substring(1, cString.length())
  }
}
// END groovy_camelize_category