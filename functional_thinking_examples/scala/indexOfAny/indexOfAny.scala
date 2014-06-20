// BEGIN scala_firstIndexOfAny
def firstIndexOfAny(input : String, searchChars : Seq[Char]) : Option[Int] = {
  def indexedInput = (0 until input.length).zip(input)
  val result = for (pair <- indexedInput;
                    char <- searchChars;
                    if (char == pair._2)) yield (pair._1)
  if (result.isEmpty) 
    None 
  else 
    Some(result.head)
}
// END scala_firstIndexOfAny

// BEGIN scala_indexOfAny
def indexOfAny(input : String, searchChars : Seq[Char]) : Seq[Int] = {
  def indexedInput = (0 until input.length).zip(input)
  for (pair <- indexedInput; 
       char <- searchChars; 
       if (char == pair._2)) yield (pair._1)
}
// END scala_indexOfAny

def indexedInput(input : Seq[Char]) : Seq[Any] = {
  (0 until input.length).zip(input)
}



println("boundary conditions\n================")  
println(firstIndexOfAny("", "") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
println(firstIndexOfAny("", "a") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
println(firstIndexOfAny("z", "") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
println(firstIndexOfAny("aba", "z") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")

println("\nfirstIndexOfAny tests\n================")  
println(firstIndexOfAny("zzabyycdxx", "za").get, "expected: 0")
println(firstIndexOfAny("zzabyycdxx", "by").get, "expected: 3")
println(firstIndexOfAny("zzyabyycdxx", "by").get, "expected: 2")


println("\nindexOfAny tests\n================")  
println(indexOfAny("zzabyycdxx", ""), "expected: []")
println(indexOfAny("", "za"), "expected: []")
println(indexOfAny("", ""), "expected: []")
println(indexOfAny("zzabyycdxx", "za"), "expected: [0 1 2]")
println(indexOfAny("zzabyycdxx", "by"), "expected: [3 4 5]")
println(indexOfAny("zzabyycdxx", "ax"), "expected: [2 8 9]")
println(indexOfAny("zxzabyycdx", "ax"), "expected: [1 3 9]")

println("\nindexed collection\n================")
println(indexedInput("zabycdxx"))



