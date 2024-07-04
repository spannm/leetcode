package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0991 extends LeetcodeProblem {

    int brokenCalc(int _x, int _y) {
        int ops = 0;
        while (_y > _x) {
            ops++;
            if (_y % 2 != 0) {
                _y++;
            } else {
                _y /= 2;
            }
        }
        return ops + _x - _y;
    }

}
