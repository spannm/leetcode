package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 866. Prime Palindrome.
 */
class Problem0866 extends LeetcodeProblem {

    int primePalindrome(int _n) {
        while (true) {
            if (reverse(_n) == _n && isPrime(_n)) {
                return _n;
            } else if (_n > 10000000 && _n < 100000000) {
                _n = 100000000;
            }
            _n++;
        }
    }

    static boolean isPrime(int _x) {
        if (_x < 2) {
            return false;
        }
        for (int v = 2; v * v <= _x; v++) {
            if (_x % v == 0) {
                return false;
            }
        }
        return true;
    }

    static int reverse(int _x) {
        int res = 0;
        while (_x != 0) {
            res = res * 10 + _x % 10;
            _x /= 10;
        }
        return res;
    }

}
