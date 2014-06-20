def volume = { h, w, l -> return h * w * l }
def area = volume.curry(1)
def lengthPA = volume.curry(1, 1) // <1>
def lengthC = volume.curry(1).curry(1) // <2>

println "The volume of the 2x3x4 rectangular solid is ${volume(2, 3, 4)}"
println "The area of the 3x4 rectangle is ${area(3, 4)}"
println "The length of the 6 line is ${lengthPA(6)}"
println "The length of the 6 line via curried function is ${lengthC(6)}"