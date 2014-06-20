package com.nealford.javanext.memoizehashing

class NameHash {
  def static hash = {name ->
    name.collect{rot13(it)}.join()
  }.memoize()

  public static char rot13(s) {
    char c = s
    switch (c) {
      case 'A'..'M':
      case 'a'..'m': return c + 13
      case 'N'..'Z':
      case 'n'..'z': return c - 13
      default: return c
    }
  }

}
