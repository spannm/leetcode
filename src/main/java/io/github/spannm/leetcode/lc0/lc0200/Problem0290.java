package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0290 extends LeetcodeProblem {

    boolean wordPattern(String _pattern, String _str) {
        String[] words = _str.split(" ");
        if (_pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        char[] patterns = _pattern.toCharArray();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])) {
                if (!map.get(patterns[i]).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(patterns[i], words[i]);
            }
        }
        return true;
    }

}
