package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1124. Longest Well-Performing Interval.
 */
class Problem1124 extends LeetcodeProblem {

    int longestWPI(int[] _hours) {
        int ans = 0;
        int s = 0;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < _hours.length; i++) {
            s += _hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                ans = i + 1;
            } else if (pos.containsKey(s - 1)) {
                ans = Math.max(ans, i - pos.get(s - 1));
            }
            pos.putIfAbsent(s, i);
        }
        return ans;
    }

}
