package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2485. Find the Pivot Integer.
 */
class Problem2485 extends LeetcodeProblem {

    int pivotInteger(int n) {
        int y = n * (n + 1) / 2;
        int x = (int) Math.sqrt(y);
        return x * x == y ? x : -1;
    }

}
