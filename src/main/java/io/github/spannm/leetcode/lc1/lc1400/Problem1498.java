package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/"> 1498. Number of
 * Subsequences That Satisfy the Given Sum Condition</a>.
 */
class Problem1498 extends LeetcodeProblem {

    static int numSubseq(final int[] _nums, final int _target) {
        Arrays.sort(_nums);
        final int len = _nums.length;

        final int mod = (int) 1e9 + 7;
        final int[] pows = new int[len];

        int l = 0;
        int r = len - 1;
        int res = 0;

        pows[0] = 1;
        for (int i = 1; i < len; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        while (l <= r) {
            if (_nums[l] + _nums[r] > _target) {
                r--;
            } else {
                res = (res + pows[r - l]) % mod;
                l++;
            }
        }
        return res;
    }

}
