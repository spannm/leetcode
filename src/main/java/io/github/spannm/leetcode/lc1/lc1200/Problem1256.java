package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1256. Encode Number.
 */
class Problem1256 extends LeetcodeProblem {

    String encode(int _num) {
        return Integer.toBinaryString(_num + 1).substring(1);
    }

}
