package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0201 extends LeetcodeProblem {

    int rangeBitwiseAnd(int _left, int _right) {
        int shift = 0;
        while (_left != _right) {
            _left >>= 1;
            _right >>= 1;
            shift++;
        }
        return _right << shift;
    }

}
