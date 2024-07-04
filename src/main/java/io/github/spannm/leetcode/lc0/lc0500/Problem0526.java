package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0526 extends LeetcodeProblem {

    int countArrangement(int _n) {
        return backtrack(_n, new int[_n + 1], 1, 0);
    }

    static int backtrack(int _n, int[] _used, int _pos, int _count) {
        if (_pos > _n) {
            _count++;
            return _count;
        }

        for (int i = 1; i <= _n; i++) {
            if (_used[i] == 0 && (i % _pos == 0 || _pos % i == 0)) {
                _used[i] = 1;
                _count = backtrack(_n, _used, _pos + 1, _count);
                _used[i] = 0;
            }
        }
        return _count;
    }

}
