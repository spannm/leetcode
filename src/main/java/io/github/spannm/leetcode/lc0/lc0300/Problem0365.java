package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0365 extends LeetcodeProblem {

    boolean canMeasureWater(int _x, int _y, int _z) {
        if (_x + _y < _z) {
            return false;
        } else if (_x == _z || _y == _z || _x + _y == _z) {
            return true;
        }
        return 0 == _z % gcd(_x, _y);
    }

    static int gcd(int _x, int _y) {
        while (_y != 0) {
            int tmp = _y;
            _y = _x % _y;
            _x = tmp;
        }
        return _x;
    }

}
