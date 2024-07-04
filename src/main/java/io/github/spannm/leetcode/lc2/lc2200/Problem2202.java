package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2202. Maximize the Topmost Element After K Moves.
 */
class Problem2202 extends LeetcodeProblem {

    int maximumTop(int[] nums, int k) {
        if (k == 0) {
            return nums[0];
        }
        int n = nums.length;
        if (n == 1) {
            if (k % 2 == 1) {
                return -1;
            }
            return nums[0];
        }
        int ans = -1;
        for (int i = 0; i < Math.min(k - 1, n); i++) {
            ans = Math.max(ans, nums[i]);
        }
        if (k < n) {
            ans = Math.max(ans, nums[k]);
        }
        return ans;
    }

}
