// when clause for innermost for
indexOfAny(str, searchChars) {
    when(searchChars) {
	csLen = str.length();                    
	for (i = 0; i < csLen; i++) {            
	    ch = str.charAt(i);
	    when (searchChars(ch)) i;
	}
    }
}