package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3017. Count the Number of Houses at a Certain Distance II.
 */
class Problem3017 extends LeetcodeProblem {

    long[] countOfPairs(int _n, int _x, int _y) {
        _x--;
        --_y;
        if (_x > _y) {
            int temp = _x;
            _x = _y;
            _y = temp;
        }
        long[] diff = new long[_n];
        for (int i = 0; i < _n; i++) {
            diff[0] += 1 + 1;
            diff[Math.min(Math.abs(i - _x), Math.abs(i - _y) + 1)]++;
            diff[Math.min(Math.abs(i - _y), Math.abs(i - _x) + 1)]++;
            diff[Math.min(Math.abs(i - 0), Math.abs(i - _y) + 1 + Math.abs(_x - 0))]--;
            diff[Math.min(Math.abs(i - (_n - 1)), Math.abs(i - _x) + 1 + Math.abs(_y - (_n - 1)))]--;
            diff[Math.max(_x - i, 0) + Math.max(i - _y, 0) + (_y - _x + 0) / 2]--;
            diff[Math.max(_x - i, 0) + Math.max(i - _y, 0) + (_y - _x + 1) / 2]--;
        }
        for (int i = 0; i + 1 < _n; i++) {
            diff[i + 1] += diff[i];
        }
        return diff;
    }

}
