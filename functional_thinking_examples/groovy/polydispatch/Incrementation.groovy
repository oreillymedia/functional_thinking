package com.nealford.ft.polydispatch

class Incrementation implements Product {
  @Override
  int evaluate(int op1, int op2) {
    def sum = 0
    op2.times {
      sum += op1
    }
    sum
  }
}
