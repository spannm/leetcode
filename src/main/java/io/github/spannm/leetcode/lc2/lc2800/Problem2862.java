package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2862. Maximum Element-Sum of a Complete Subset of Indices.
 */
class Problem2862 extends LeetcodeProblem {

    long maximumSum(List<Integer> nums) {
        long ans = 0;
        int n = nums.size();
        for (int k = 1; k <= n; k++) {
            long t = 0;
            for (int j = 1; k * j * j <= n; j++) {
                t += nums.get(k * j * j - 1);
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

}
