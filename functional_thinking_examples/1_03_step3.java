// remove type decls
indexOfAny(str, searchChars) {
    when(searchChars) {
	csLen = str.length();                    
	csLast = csLen - 1;
	searchLen = searchChars.length;
	searchLast = searchLen - 1;
	for (i = 0; i < csLen; i++) {            
	    ch = str.charAt(i);
	    for (j = 0; j < searchLen; j++) {    
		if (searchChars[j] == ch) {      
		    if (i < csLast && j < searchLast && CharUtils.isHighSurrogate(ch)) {
			if (searchChars[j + 1] == str.charAt(i + 1)) {
			    return i;
			}
		    } else {
			return i;
		    }
	        }
	    }
	}
	return INDEX_NOT_FOUND;
    }
}