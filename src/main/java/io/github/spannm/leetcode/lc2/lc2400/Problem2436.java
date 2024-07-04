package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2436. Minimum Split Into Subarrays With GCD Greater Than One.
 */
class Problem2436 extends LeetcodeProblem {

    int minimumSplits(int[] nums) {
        int ans = 1;
        int g = 0;
        for (int x : nums) {
            g = gcd(g, x);
            if (g == 1) {
                ans++;
                g = x;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
