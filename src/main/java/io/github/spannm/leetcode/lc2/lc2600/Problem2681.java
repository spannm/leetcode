package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2681. Power of Heroes.
 */
class Problem2681 extends LeetcodeProblem {

    int sumOfPower(int[] nums) {
        final int mod = (int) 1e9 + 7;
        Arrays.sort(nums);
        long ans = 0;
        long p = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long x = nums[i];
            ans = (ans + x * x % mod * x) % mod;
            ans = (ans + x * p % mod) % mod;
            p = (p * 2 + x * x % mod) % mod;
        }
        return (int) ans;
    }

}
