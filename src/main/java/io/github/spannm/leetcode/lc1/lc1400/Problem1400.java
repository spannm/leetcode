package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1400 extends LeetcodeProblem {

    boolean canConstruct(String _s, int _k) {
        if (_s.length() < _k) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : _s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                count++;
            }
        }
        return count <= _k;
    }

}
