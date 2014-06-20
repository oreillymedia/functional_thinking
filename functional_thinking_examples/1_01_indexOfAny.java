// From Apache Commons Lang, http://commons.apache.org/lang/
public static int indexOfAny(String str, char[] searchChars) {
    if (isEmpty(str) || ArrayUtils.isEmpty(searchChars)) { <1>
	return INDEX_NOT_FOUND;
    }
    int csLen = str.length();                    <2>
    int csLast = csLen - 1;
    int searchLen = searchChars.length;
    int searchLast = searchLen - 1;
    for (int i = 0; i < csLen; i++) {            <3>
	char ch = str.charAt(i);
        for (int j = 0; j < searchLen; j++) {    <4>
	    if (searchChars[j] == ch) {          <5> 
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