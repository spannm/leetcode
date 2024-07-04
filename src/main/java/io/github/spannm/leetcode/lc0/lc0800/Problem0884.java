package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0884 extends LeetcodeProblem {

    String[] uncommonFromSentences(String _a, String _b) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : _a.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : _b.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                result.add(key);
            }
        }
        String[] strs = new String[result.size()];
        result.toArray(strs);
        return strs;
    }

}
