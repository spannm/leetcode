package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 858. Mirror Reflection.
 */
class Problem0858 extends LeetcodeProblem {

    int mirrorReflection(int _p, int _q) {
        int g = gcd(_p, _q);
        _p = _p / g % 2;
        _q = _q / g % 2;
        if (_p == 1 && _q == 1) {
            return 1;
        }
        return _p == 1 ? 0 : 2;
    }

    private int gcd(int _a, int _b) {
        return _b == 0 ? _a : gcd(_b, _a % _b);
    }

}
