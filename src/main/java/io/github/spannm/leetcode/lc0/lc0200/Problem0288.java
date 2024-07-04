package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0288 extends LeetcodeProblem {

    static class ValidWordAbbr {
        private final Map<String, String> dict;

        ValidWordAbbr(String[] _dict) {
            dict = new HashMap<>();
            for (String word : _dict) {
                String key = word.length() <= 2 ? word : word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
                if (dict.containsKey(key) && !dict.get(key).equals(word)) {
                    dict.put(key, "");
                } else {
                    dict.put(key, word);
                }
            }
        }

        boolean isUnique(String _word) {
            String key = _word.length() <= 2 ? _word : _word.charAt(0) + String.valueOf(_word.length() - 2) + _word.charAt(_word.length() - 1);
            return !dict.containsKey(key) || dict.get(key).equals(_word);
        }
    }

}
