package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;

class Problem1371 extends LeetcodeProblem {

    int findTheLongestSubstring(String _s) {
        int max = 0;
        for (int i = 0; i < _s.length(); i++) {
            Map<Character, Integer> map = Map.of(
                'a', 0,
                'e', 0,
                'i', 0,
                'o', 0,
                'u', 0);
            if (_s.length() - i < max) {
                return max;
            }
            for (int j = i; j < _s.length(); j++) {
                Character b = _s.charAt(j);
                if (map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                }
                if (isAllEven(map)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    private static boolean isAllEven(Map<Character, Integer> _map) {
        for (char c : _map.keySet()) {
            if (_map.get(c) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

}
