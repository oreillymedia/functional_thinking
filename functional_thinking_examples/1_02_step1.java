//simplify corner cases
public static int indexOfAny(String str, char[] searchChars) {
    when(searchChars) {                        <1>
	int csLen = str.length();                    
	int csLast = csLen - 1;
	int searchLen = searchChars.length;
	int searchLast = searchLen - 1;
	for (int i = 0; i < csLen; i++) {            
		char ch = str.charAt(i);
	    for (int j = 0; j < searchLen; j++) {    
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