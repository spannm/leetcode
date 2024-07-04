package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2481. Minimum Cuts to Divide a Circle.
 */
class Problem2481 extends LeetcodeProblem {

    int numberOfCuts(int n) {
        return n > 1 && n % 2 == 1 ? n : n >> 1;
    }

}
