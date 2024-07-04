package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2240. Number of Ways to Buy Pens and Pencils.
 */
class Problem2240 extends LeetcodeProblem {

    long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        for (int x = 0; x <= total / cost1; x++) {
            int y = (total - x * cost1) / cost2 + 1;
            ans += y;
        }
        return ans;
    }

}
