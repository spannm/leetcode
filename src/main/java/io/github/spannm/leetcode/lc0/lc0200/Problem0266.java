package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0266 extends LeetcodeProblem {

    boolean canPermutePalindrome(String _s) {
        char[] chars = _s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int evenCount = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 != 0) {
                evenCount++;
            }
            if (evenCount > 1) {
                return false;
            }
        }
        return true;
    }

}
