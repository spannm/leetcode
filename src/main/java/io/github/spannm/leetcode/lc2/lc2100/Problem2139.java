package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2139 extends LeetcodeProblem {

    int minMoves(int _target, int _maxDoubles) {
        int minMoves = 0;
        while (_target != 1) {
            if (_maxDoubles > 0) {
                if (_target % 2 == 0) {
                    _target /= 2;
                    _maxDoubles--;
                } else {
                    _target--;
                }
            } else {
                minMoves += _target - 1;
                break;
            }
            minMoves++;
        }
        return minMoves;
    }

}
