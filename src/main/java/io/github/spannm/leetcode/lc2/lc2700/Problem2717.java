package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2717. Semi-Ordered Permutation.
 */
class Problem2717 extends LeetcodeProblem {

    int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (nums[k] == 1) {
                i = k;
            }
            if (nums[k] == n) {
                j = k;
            }
        }
        int k = i < j ? 1 : 2;
        return i + n - j - k;
    }

}
