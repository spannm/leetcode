package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2500. Delete Greatest Value in Each Row.
 */
class Problem2500 extends LeetcodeProblem {

    int deleteGreatestValue(int[][] grid) {
        for (var row : grid) {
            Arrays.sort(row);
        }
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            int t = 0;
            for (int[] element : grid) {
                t = Math.max(t, element[j]);
            }
            ans += t;
        }
        return ans;
    }

}
