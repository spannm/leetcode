package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2283 extends LeetcodeProblem {

    boolean digitCount(String _num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : _num.toCharArray()) {
            int n = Character.getNumericValue(c);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < _num.length(); i++) {
            int n = Character.getNumericValue(_num.charAt(i));
            int times = map.getOrDefault(i, 0);
            if (n != times) {
                return false;
            }
        }
        return true;
    }

}
