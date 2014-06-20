def Closure makeCounter() {
  def local_variable = 0
  return { return local_variable += 1 }  // <1>
}

c1 = makeCounter()    // <2>
c1()                  // <3>
c1()
c1()

c2 = makeCounter()    // <4>

println "C1 = ${c1()}, C2 = ${c2()}"
// output: C1 = 4, C2 = 1  // <5>
