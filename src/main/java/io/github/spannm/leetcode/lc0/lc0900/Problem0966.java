package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem0966 extends LeetcodeProblem {

    String[] spellchecker(String[] _wordlist, String[] _queries) {
        Map<String, String> caseMap = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String word : _wordlist) {
            caseMap.putIfAbsent(word.toLowerCase(), word);
            set.add(word);
        }

        Map<String, String> vowelMap = new HashMap<>();
        for (String word : _wordlist) {
            String genericVal = makeGenericVowel(word);
            if (!vowelMap.containsKey(genericVal)) {
                vowelMap.put(genericVal, word);
            }
        }

        String[] ans = new String[_queries.length];

        for (int i = 0; i < _queries.length; i++) {
            if (set.contains(_queries[i])) {
                ans[i] = _queries[i];
            } else if (caseMap.containsKey(_queries[i].toLowerCase())) {
                ans[i] = caseMap.get(_queries[i].toLowerCase());
            } else {
                ans[i] = vowelMap.getOrDefault(makeGenericVowel(_queries[i]), "");
            }
        }
        return ans;
    }

    private String makeGenericVowel(String _s) {
        String vowel = "aeiou";
        char[] ch = _s.toLowerCase().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (vowel.indexOf(ch[i]) != -1) {
                ch[i] = '#';
            }
        }
        return String.valueOf(ch);
    }

}
