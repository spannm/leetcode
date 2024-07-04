package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 397. Integer Replacement.
 */
class Problem0397 extends LeetcodeProblem {

    int integerReplacement(int _n) {
        int ans = 0;
        while (_n != 1) {
            if ((_n & 1) == 0) {
                _n >>>= 1;
            } else if (_n != 3 && (_n & 3) == 3) {
                _n++;
            } else {
                _n--;
            }
            ans++;
        }
        return ans;
    }

}
