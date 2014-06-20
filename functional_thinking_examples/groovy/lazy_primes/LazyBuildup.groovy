// BEGIN plazylist
class PLazyList {
  private Closure list

  private PLazyList(list) {
    this.list = list
  }

  static PLazyList nil() {
    new PLazyList({-> []})
  }

  PLazyList cons(head) {
    new PLazyList({-> [head, list]})
  }

  def head() {
    def lst = list.call()
    lst ? lst[0] : null
  }

  def tail() {
    def lst = list.call()
    lst ? new PLazyList(lst.tail()[0]) : nil()
  }

  boolean isEmpty() {
    list.call() == []
  }

  def fold(n, acc, f) {
    n == 0 || isEmpty() ? acc : tail().fold(n - 1, f.call(acc, head()), f)
  }

  def foldAll(acc, f) {
    isEmpty() ? acc : tail().foldAll(f.call(acc, head()), f)
  }

  def take(n) {
    fold(n, []) {acc, item -> acc << item}
  }

  def takeAll() {
    foldAll([]) {acc, item -> acc << item}
  }

  def toList() {
    takeAll()
  }
}
// END plazylist

// BEGIN plazylist_demo
def lazylist = PLazyList.nil().cons(4).cons(3).cons(2).cons(1)
println(lazylist.takeAll())
println(lazylist.foldAll(0, {i, j -> i + j}))
lazylist = PLazyList.nil().cons(1).cons(2).cons(4).cons(8)
println(lazylist.take(2))
// END plazylist_demo
