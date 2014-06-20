package com.nealford.functionalthinking.trans

class TheCompanyProcess {
// BEGIN groovy_process
  public static String cleanUpNames(listOfNames) {
    listOfNames
        .findAll { it.length() > 1 }
        .collect { it.capitalize() }
        .join ','
  }
// END groovy_process

}
