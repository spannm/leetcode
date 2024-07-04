package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2897. Apply Operations on Array to Maximize Sum of Squares.
 */
class Problem2897 extends LeetcodeProblem {

    int maxSum(List<Integer> nums, int k) {
        final int mod = (int) 1e9 + 7;
        int[] cnt = new int[31];
        for (int x : nums) {
            for (int i = 0; i < 31; i++) {
                if ((x >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        long ans = 0;
        while (k-- > 0) {
            int x = 0;
            for (int i = 0; i < 31; i++) {
                if (cnt[i] > 0) {
                    x |= 1 << i;
                    cnt[i]--;
                }
            }
            ans = (ans + 1L * x * x) % mod;
        }
        return (int) ans;
    }

}
