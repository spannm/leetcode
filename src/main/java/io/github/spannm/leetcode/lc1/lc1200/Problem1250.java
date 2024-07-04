package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1250. Check If It Is a Good Array.
 */
class Problem1250 extends LeetcodeProblem {

    boolean isGoodArray(int[] _nums) {
        int g = 0;
        for (int n : _nums) {
            g = calcGcd(n, g);
        }
        return g == 1;
    }

    static int calcGcd(int _a, int _b) {
        return _b == 0 ? _a : calcGcd(_b, _a % _b);
    }

}
