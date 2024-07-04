package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1688 extends LeetcodeProblem {

    int numberOfMatches(int _n) {
        int matches = 0;
        while (_n > 1) {
            if (_n % 2 == 0) {
                matches += _n / 2;
                _n /= 2;
            } else {
                matches += (_n - 1) / 2;
                _n = (_n + 1) / 2;
            }
        }
        return matches;
    }

}
