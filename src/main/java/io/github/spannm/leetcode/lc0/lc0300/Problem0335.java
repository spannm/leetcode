package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0335 extends LeetcodeProblem {

    boolean isSelfCrossing(int[] _x) {
        final int len = _x.length;
        if (len <= 3) {
            return false;
        }

        for (int i = 3; i < len; i++) {
            if (_x[i] >= _x[i - 2] && _x[i - 1] <= _x[i - 3]
                || i >= 4 && _x[i - 1] == _x[i - 3] && _x[i] + _x[i - 4] >= _x[i - 2]
                || i >= 5 && _x[i - 2] - _x[i - 4] >= 0
                    && _x[i] >= _x[i - 2] - _x[i - 4]
                    && _x[i - 1] >= _x[i - 3] - _x[i - 5]
                    && _x[i - 1] <= _x[i - 3]) {
                return true;
            }
        }
        return false;
    }

}
