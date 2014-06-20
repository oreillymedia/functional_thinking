// add comprehension
indexOfAny(str, searchChars) {
    when(searchChars) {
	for ([i, ch] in indexed(str)) {    <1>
	    when (searchChars(ch)) i;
	}
    }
}