// BEGIN iterate_groovy
def perfectNumbers = [6, 28, 496, 8128]

def iterateList(listOfNums) {
  listOfNums.each { println "${it}" }
}

iterateList(perfectNumbers)
// END iterate_groovy

// BEGIN recurse_groovy
def recurseList(listOfNums) {
  if (listOfNums.size > 0) {
    println "${listOfNums.head()}"
    recurseList(listOfNums.tail())
  }
}
// END recurse_groovy

recurseList(perfectNumbers)

// BEGIN iterative_filter_groovy
def filter(list, predicate) {
  def new_list = []
  list.each { 
    if (predicate(it)) {
      new_list << it
    }
   }
   return new_list
}

modBy2 = { n -> n % 2 == 0}

l = filter(1..20, modBy2)
println l
// END iterative_filter_groovy

// BEGIN recursive_filter_groovy
def filterR(list, pred) {
  if (list.size() == 0) return list
  if (pred(list.head()))
    [] + list.head() + filterR(list.tail(), pred)
  else filterR(list.tail(), pred)
}
// END recursive_filter_groovy

println "filtering"
l = filter(1..20, {n-> n % 2 == 0})
l.each {i-> println "${i}"}

