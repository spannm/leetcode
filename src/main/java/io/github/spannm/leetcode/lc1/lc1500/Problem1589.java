package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1589. Maximum Sum Obtained of Any Permutation.
 */
class Problem1589 extends LeetcodeProblem {

    int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] d = new int[n];
        for (var req : requests) {
            int l = req[0];
            int r = req[1];
            d[l]++;
            if (r + 1 < n) {
                d[r + 1]--;
            }
        }
        for (int i = 1; i < n; i++) {
            d[i] += d[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(d);
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + 1L * nums[i] * d[i]) % mod;
        }
        return (int) ans;
    }

}
