package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1144. Decrease Elements To Make Array Zigzag.
 */
class Problem1144 extends LeetcodeProblem {

    int movesToMakeZigzag(int[] _nums) {
        int[] ans = new int[2];
        int n = _nums.length;
        for (int i = 0; i < 2; i++) {
            for (int j = i; j < n; j += 2) {
                int d = 0;
                if (j > 0) {
                    d = Math.max(d, _nums[j] - _nums[j - 1] + 1);
                }
                if (j < n - 1) {
                    d = Math.max(d, _nums[j] - _nums[j + 1] + 1);
                }
                ans[i] += d;
            }
        }
        return Math.min(ans[0], ans[1]);
    }

}
