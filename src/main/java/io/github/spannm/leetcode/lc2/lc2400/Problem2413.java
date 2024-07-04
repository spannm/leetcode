package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2413. Smallest Even Multiple.
 */
class Problem2413 extends LeetcodeProblem {

    int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }

}
