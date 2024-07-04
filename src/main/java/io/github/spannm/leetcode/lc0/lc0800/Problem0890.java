package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0890 extends LeetcodeProblem {

    List<String> findAndReplacePattern(String[] _words, String _pattern) {
        List<String> result = new ArrayList<>();
        for (String word : _words) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            boolean match = true;
            for (int i = 0; i < _pattern.length(); i++) {
                if (map.containsKey(_pattern.charAt(i))) {
                    if (word.charAt(i) != map.get(_pattern.charAt(i))) {
                        match = false;
                        break;
                    }
                } else {
                    map.put(_pattern.charAt(i), word.charAt(i));
                    if (!set.add(word.charAt(i))) {
                        match = false;
                    }
                }
            }
            if (match) {
                result.add(word);
            }
        }
        return result;
    }

}
