// BEGIN groovy_iterate
def numbers = [6, 28, 4, 9, 12, 4, 8, 8, 11, 45, 99, 2]

def iterateList(listOfNums) {
  listOfNums.each { n ->
    println "${n}"
  }
}
println "Iterate List"
iterateList(numbers)
// END groovy_iterate

// BEGIN groovy_recurse
def recurseList(listOfNums) {
  if (listOfNums.size == 0) return;
    println "${listOfNums.head()}"
    recurseList(listOfNums.tail())
}
println "\nRecurse List"
recurseList(numbers)
// END groovy_recurse

// BEGIN groovy_imp_filter
def filterI(list, pred) {
  def new_list = []
  list.each { i ->
    if (pred(i))
      new_list << i
  }
  new_list
}

println "Imperative filtering"
println filterI(1..20, {it % 2 == 0})
// [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
// END groovy_imp_filter

// BEGIN groovy_recurse_filter
def filterR(list, pred) {
  if (list.size() == 0) return list
  if (pred(list.head()))
    [] + list.head() + filterR(list.tail(), pred)
  else
    filterR(list.tail(), pred)
}

println "Recursive Filtering"
println filterR(1..20, {it % 2 == 0})
//// [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
// END groovy_recurse_filter
