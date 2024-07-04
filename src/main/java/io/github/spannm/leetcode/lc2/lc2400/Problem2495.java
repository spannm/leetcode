package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2495. Number of Subarrays Having Even Product.
 */
class Problem2495 extends LeetcodeProblem {

    long evenProduct(int[] nums) {
        long ans = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                last = i;
            }
            ans += last + 1;
        }
        return ans;
    }

}
