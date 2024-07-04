package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0372 extends LeetcodeProblem {

    int superPow(int _a, int[] _b) {
        if (_a % 1337 == 0) {
            return 0;
        }
        int p = 0;
        for (int i : _b) {
            p = (p * 10 + i) % 1140;
        }
        if (p == 0) {
            p += 1140;
        }
        return power(_a, p, 1337);
    }

    private static int power(int _a, int _n, int _mod) {
        _a %= _mod;
        int result = 1;
        while (_n != 0) {
            if ((_n & 1) != 0) {
                result = result * _a % _mod;
            }
            _a = _a * _a % _mod;
            _n >>= 1;
        }
        return result;
    }

}
