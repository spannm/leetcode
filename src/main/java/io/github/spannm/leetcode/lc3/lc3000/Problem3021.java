package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3021. Alice and Bob Playing Flower Game.
 */
class Problem3021 extends LeetcodeProblem {

    long flowerGame(int _n, int _m) {
        long a1 = (_n + 1) / 2;
        long b1 = (_m + 1) / 2;
        long a2 = _n / 2;
        long b2 = _m / 2;
        return a1 * b2 + a2 * b1;
    }

}
