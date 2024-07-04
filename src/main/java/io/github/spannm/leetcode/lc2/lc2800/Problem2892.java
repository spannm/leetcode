package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2892. Minimizing Array After Replacing Pairs With Their Product.
 */
class Problem2892 extends LeetcodeProblem {

    int minArrayLength(int[] nums, int k) {
        int ans = 1;
        long y = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == 0) {
                return 1;
            }
            if (x * y <= k) {
                y *= x;
            } else {
                y = x;
                ans++;
            }
        }
        return ans;
    }

}
