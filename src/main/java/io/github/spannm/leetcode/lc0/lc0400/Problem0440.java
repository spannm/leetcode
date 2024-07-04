package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0440 extends LeetcodeProblem {

    int findKthNumber(int _n, int _k) {
        int curr = 1;
        _k = _k - 1;
        while (_k > 0) {
            int steps = calcSteps(_n, curr, curr + 1);
            if (steps <= _k) {
                curr += 1;
                _k -= steps;
            } else {
                curr *= 10;
                _k -= 1;
            }
        }
        return curr;
    }

    static int calcSteps(int _n, long _n1, long _n2) {
        int steps = 0;
        while (_n1 <= _n) {
            steps += Math.min(_n + 1, _n2) - _n1;
            _n1 *= 10;
            _n2 *= 10;
        }
        return steps;
    }

}
