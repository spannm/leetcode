package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0249 extends LeetcodeProblem {

    List<List<String>> groupStrings(String[] _strings) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : _strings) {
            String key = "";
            int offset = word.charAt(0) - 'a';
            for (int i = 1; i < word.length(); i++) {
                key += (word.charAt(i) - offset + 26) % 26;
            }

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }

}
