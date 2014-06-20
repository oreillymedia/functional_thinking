def isPalindrome(s) {
  def sl = s.toLowerCase()
  sl == sl.reverse()
}

def findFirstPalindrome(s) {
  s.tokenize(' ').find {isPalindrome(it)}
}

s1 = "The quick brown fox jumped over anna the dog";
println(findFirstPalindrome(s1))
s2 = "Bob went to Harrah and gambled with Otto and Steve"
println(findFirstPalindrome(s2))