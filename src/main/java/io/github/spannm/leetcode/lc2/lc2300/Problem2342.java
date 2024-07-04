package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits.
 */
class Problem2342 extends LeetcodeProblem {

    int maximumSum(int[] nums) {
        int[] d = new int[100];
        int ans = -1;
        for (int v : nums) {
            int x = 0;
            for (int y = v; y > 0; y /= 10) {
                x += y % 10;
            }
            if (d[x] > 0) {
                ans = Math.max(ans, d[x] + v);
            }
            d[x] = Math.max(d[x], v);
        }
        return ans;
    }

}
