package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2815. Max Pair Sum in an Array.
 */
class Problem2815 extends LeetcodeProblem {

    int maxSum(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = nums[i] + nums[j];
                if (ans < v && f(nums[i]) == f(nums[j])) {
                    ans = v;
                }
            }
        }
        return ans;
    }

    private int f(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = Math.max(y, x % 10);
        }
        return y;
    }

}
