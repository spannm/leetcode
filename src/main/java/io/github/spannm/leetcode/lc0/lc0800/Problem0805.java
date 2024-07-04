package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 805. Split Array With Same Average.
 */
class Problem0805 extends LeetcodeProblem {

    boolean splitArraySameAverage(int[] _nums) {
        int len = _nums.length;
        if (len == 1) {
            return false;
        }
        int s = Arrays.stream(_nums).sum();
        for (int i = 0; i < len; i++) {
            _nums[i] = _nums[i] * len - s;
        }
        int m = len >> 1;
        Set<Integer> vis = new HashSet<>();
        for (int i = 1; i < 1 << m; i++) {
            int t = 0;
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    t += _nums[j];
                }
            }
            if (t == 0) {
                return true;
            }
            vis.add(t);
        }
        for (int i = 1; i < 1 << len - m; i++) {
            int t = 0;
            for (int j = 0; j < len - m; j++) {
                if ((i >> j & 1) == 1) {
                    t += _nums[m + j];
                }
            }
            if (t == 0 || i != (1 << len - m) - 1 && vis.contains(-t)) {
                return true;
            }
        }
        return false;
    }

}
