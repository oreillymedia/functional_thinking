package com.nealford.ft.polydispatch

class Multiply implements Product {
  @Override
  int evaluate(int op1, int op2) {
    op1 * op2
  }
}
