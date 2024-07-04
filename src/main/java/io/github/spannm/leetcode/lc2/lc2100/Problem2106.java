package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2106. Maximum Fruits Harvested After at Most K Steps.
 */
class Problem2106 extends LeetcodeProblem {

    int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int s = 0;
        for (int i = 0, j = 0; j < fruits.length; j++) {
            int pj = fruits[j][0];
            int fj = fruits[j][1];
            s += fj;
            while (i <= j
                && pj - fruits[i][0]
                    + Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - pj)) > k) {
                s -= fruits[i++][1];
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }

}
