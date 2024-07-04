package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2145. Count the Hidden Sequences.
 */
class Problem2145 extends LeetcodeProblem {

    int numberOfArrays(int[] differences, int lower, int upper) {
        long num = 0;
        long mi = 0;
        long mx = 0;
        for (int d : differences) {
            num += d;
            mi = Math.min(mi, num);
            mx = Math.max(mx, num);
        }
        return Math.max(0, (int) (upper - lower - (mx - mi) + 1));
    }

}
