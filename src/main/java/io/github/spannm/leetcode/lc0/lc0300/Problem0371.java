package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0371 extends LeetcodeProblem {

    int getSum(int _a, int _b) {
        return _b == 0 ? _a : getSum(_a ^ _b, (_a & _b) << 1);
    }

}
