package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2412. Minimum Money Required Before Transactions.
 */
class Problem2412 extends LeetcodeProblem {

    long minimumMoney(int[][] transactions) {
        long s = 0;
        for (var e : transactions) {
            s += Math.max(0, e[0] - e[1]);
        }
        long ans = 0;
        for (var e : transactions) {
            if (e[0] > e[1]) {
                ans = Math.max(ans, s + e[1]);
            } else {
                ans = Math.max(ans, s + e[0]);
            }
        }
        return ans;
    }

}
