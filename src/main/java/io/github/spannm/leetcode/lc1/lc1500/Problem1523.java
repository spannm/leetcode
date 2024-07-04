package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1523 extends LeetcodeProblem {

    int countOdds(int _low, int _high) {
        if (_low % 2 != 0 || _high % 2 != 0) {
            return (_high - _low) / 2 + 1;
        }
        return (_high - _low) / 2;
    }

}
