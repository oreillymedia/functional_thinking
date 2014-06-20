package com.nealford.ft.polydispatch

class ProductFactory {
  static Product getProduct(int maxNumber) {
    if (maxNumber > 10000)
      return new Multiply()
    else
      return new Incrementation()
  }
}
