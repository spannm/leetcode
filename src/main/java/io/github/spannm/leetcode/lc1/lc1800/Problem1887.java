package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/"> 1887. Reduction
 * Operations to Make the Array Elements Equal</a>.
 */
class Problem1887 extends LeetcodeProblem {

    int reductionOperations(int[] _nums) {
        java.util.Arrays.sort(_nums);
        int len = _nums.length;
        int prev = _nums[len - 1];
        int ans = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (prev != _nums[i]) {
                ans += len - i - 1;
                prev = _nums[i];
            }
        }
        return ans;
    }

}
