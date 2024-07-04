package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">1493. Longest Subarray of
 * 1's After Deleting One Element</a>.
 */
public class Problem1493 extends LeetcodeProblem {

    int longestSubarray(final int[] _nums) {
        final int len = _nums.length;

        int c1 = 0; // number of ones after last 0
        int c2 = 0; // count of ones before last 0
        int max = 0;

        for (int n : _nums) {
            if (n == 0) {
                max = Math.max(max, c1 + c2);
                c2 = c1;
                c1 = 0;
            } else {
                c1++;
            }
        }

        if (c1 + c2 == len) {
            return len - 1; // if there is no 0's in array, then one 1 should be deleted
        }
        return Math.max(max, c1 + c2);
    }

}
