package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2909. Minimum Sum of Mountain Triplets II.
 */
class Problem2909 extends LeetcodeProblem {

    int minimumSum(int[] nums) {
        int n = nums.length;
        int[] right = new int[n + 1];
        final int inf = 1 << 30;
        right[n] = inf;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int ans = inf;
        int left = inf;
        for (int i = 0; i < n; i++) {
            if (left < nums[i] && right[i + 1] < nums[i]) {
                ans = Math.min(ans, left + nums[i] + right[i + 1]);
            }
            left = Math.min(left, nums[i]);
        }
        return ans == inf ? -1 : ans;
    }

}
