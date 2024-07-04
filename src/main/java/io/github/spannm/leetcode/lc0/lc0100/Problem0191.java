package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits/">191. Number of 1 Bits</a>.
 */
class Problem0191 extends LeetcodeProblem {

    int hammingWeight(int _n) {
        return Integer.toBinaryString(_n).replace("0", "").length();
    }

}
