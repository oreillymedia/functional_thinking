package com.nealford.functionalthinking.wordfreq;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// BEGIN java_word_freq
public class Words {
    private Set<String> NON_WORDS = new HashSet<String>() {{
        add("the"); add("and");	add("of"); add("to"); add("a");
        add("i"); add("it"); add("in");	add("or"); add("is");
        add("d"); add("s"); add("as"); add("so"); add("but");
        add("be");
	}};

    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        Matcher m = Pattern.compile("\\w+").matcher(words);
        while (m.find()) {
            String word = m.group().toLowerCase();
            if (! NON_WORDS.contains(word)) {
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                }
                else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;
    }
}
// END java_word_freq
