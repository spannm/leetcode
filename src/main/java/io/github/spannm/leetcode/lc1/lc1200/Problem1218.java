package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/"> 1218. Longest Arithmetic
 * Subsequence of Given Difference</a>.
 */
class Problem1218 extends LeetcodeProblem {

    int longestSubsequence(final int[] _arr, final int _difference) {
        final int len = _arr.length;
        final Map<Integer, Integer> dp = new HashMap<>(len); // Stores max length at each index

        int result = 1; // Initialize with the minimum length of 1

        for (int num : _arr) {
            Integer val = dp.get(num - _difference);
            int newVal = val == null ? 1 : val + 1;
            dp.put(num, newVal);

            result = Math.max(result, newVal);
        }

        dp.clear();
        System.gc();

        return result;
    }

}
