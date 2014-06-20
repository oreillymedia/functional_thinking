package com.nealford.functionalthinking

// BEGIN groovy_camelize_category_retro
public class CamelizeCategory {
  static def camelize(String self) {  // <1>
    def newName = self.split("_").collect() { s ->
      s.substring(0, 1).toUpperCase() +
          s.substring(1, s.length())
    }.join()
    newName.substring(0, 1).toLowerCase() +
        newName.substring(1, newName.length())
  }
// END groovy_camelize_category_retro
}



