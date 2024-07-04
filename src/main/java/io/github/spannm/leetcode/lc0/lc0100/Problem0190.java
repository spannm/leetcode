package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/">190. Reverse Bits</a>.
 */
class Problem0190 extends LeetcodeProblem {

    int reverseBits(int _n) {
        if (_n == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((_n & 1) == 1) {
                res++;
            }
            _n >>= 1;
        }
        return res;
    }

}
