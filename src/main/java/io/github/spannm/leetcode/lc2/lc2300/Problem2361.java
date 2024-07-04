package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2361. Minimum Costs Using the Train Line.
 */
class Problem2361 extends LeetcodeProblem {

    long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long f = 0;
        long g = 1 << 30;
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            int a = regular[i];
            int b = express[i];
            long ff = Math.min(f + a, g + a);
            long gg = Math.min(f + expressCost + b, g + b);
            f = ff;
            g = gg;
            cost[i] = Math.min(f, g);
        }
        return cost;
    }

}
