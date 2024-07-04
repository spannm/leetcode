package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2679. Sum in a Matrix.
 */
class Problem2679 extends LeetcodeProblem {

    int matrixSum(int[][] nums) {
        for (var row : nums) {
            Arrays.sort(row);
        }
        int ans = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int mx = 0;
            for (var row : nums) {
                mx = Math.max(mx, row[j]);
            }
            ans += mx;
        }
        return ans;
    }

}
