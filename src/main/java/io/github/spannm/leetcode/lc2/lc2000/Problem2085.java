package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2085 extends LeetcodeProblem {

    int countWords(String[] _words1, String[] _words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String word : _words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }
        for (String word : _words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }
        int ans = 0;
        for (String key : map1.keySet()) {
            if (map1.get(key) == 1 && map2.containsKey(key) && map2.get(key) == 1) {
                ans++;
            }
        }
        return ans;
    }

}
