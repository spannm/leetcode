package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2745. Construct the Longest New String.
 */
class Problem2745 extends LeetcodeProblem {

    int longestString(int x, int y, int z) {
        if (x < y) {
            return (x * 2 + z + 1) * 2;
        }
        if (x > y) {
            return (y * 2 + z + 1) * 2;
        }
        return (x + y + z) * 2;
    }

}
