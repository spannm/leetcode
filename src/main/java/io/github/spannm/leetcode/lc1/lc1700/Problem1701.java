package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1701. Average Waiting Time.
 */
class Problem1701 extends LeetcodeProblem {

    double averageWaitingTime(int[][] customers) {
        double tot = 0;
        int t = 0;
        for (var e : customers) {
            int a = e[0];
            int b = e[1];
            t = Math.max(t, a) + b;
            tot += t - a;
        }
        return tot / customers.length;
    }

}
