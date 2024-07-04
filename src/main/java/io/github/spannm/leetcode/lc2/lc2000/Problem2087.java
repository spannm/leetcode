package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2087. Minimum Cost Homecoming of a Robot in a Grid.
 */
class Problem2087 extends LeetcodeProblem {

    int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int i = startPos[0];
        int j = startPos[1];
        int x = homePos[0];
        int y = homePos[1];
        int ans = 0;
        if (i < x) {
            for (int k = i + 1; k <= x; k++) {
                ans += rowCosts[k];
            }
        } else {
            for (int k = x; k < i; k++) {
                ans += rowCosts[k];
            }
        }
        if (j < y) {
            for (int k = j + 1; k <= y; k++) {
                ans += colCosts[k];
            }
        } else {
            for (int k = y; k < j; k++) {
                ans += colCosts[k];
            }
        }
        return ans;
    }

}
