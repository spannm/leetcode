package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2340. Minimum Adjacent Swaps to Make a Valid Array.
 */
class Problem2340 extends LeetcodeProblem {

    int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] < nums[i] || nums[k] == nums[i] && k < i) {
                i = k;
            }
            if (nums[k] > nums[j] || nums[k] == nums[j] && k > j) {
                j = k;
            }
        }
        if (i == j) {
            return 0;
        }
        return i + n - 1 - j - (i > j ? 1 : 0);
    }

}
