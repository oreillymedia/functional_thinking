// BEGIN groovy_adder_factory
def adder = { x, y -> x + y}
def incrementer = adder.curry(1)

println "increment 7: ${incrementer(7)}"
// END groovy_adder_factory

// BEGIN groovy_currying
def product = { x, y -> x * y }

def quadrate = product.curry(4)     // <1>
def octate = product.curry(8)       // <2>

println "4x4: ${quadrate.call(4)}"  // <3>
println "8x5: ${octate(5)}"         // <4>
// END groovy_currying

// BEGIN currying_partial
def volume = {h, w, l -> h * w * l}
def area = volume.curry(1)
def lengthPA = volume.curry(1, 1)         // <1>
def lengthC = volume.curry(1).curry(1)    // <2>

println "The volume of the 2x3x4 rectangular solid is ${volume(2, 3, 4)}"
println "The area of the 3x4 rectangle is ${area(3, 4)}"
println "The length of the 6 line is ${lengthPA(6)}"
println "The length of the 6 line via curried function is ${lengthC(6)}"
// END currying_partial


// BEGIN groovy_composite
def composite = { f, g, x -> return f(g(x)) }
def thirtyTwoer = composite.curry(quadrate, octate)

println "composition of curried functions yields ${thirtyTwoer(2)}"
// END groovy_composite
