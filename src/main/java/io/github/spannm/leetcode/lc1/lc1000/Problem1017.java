package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1017. Convert to Base -2.
 */
class Problem1017 extends LeetcodeProblem {

    String baseNeg2(int _n) {
        if (_n == 0) {
            return "0";
        }
        int k = 1;
        StringBuilder ans = new StringBuilder();
        while (_n != 0) {
            if (_n % 2 != 0) {
                ans.append(1);
                _n -= k;
            } else {
                ans.append(0);
            }
            k *= -1;
            _n /= 2;
        }
        return ans.reverse().toString();
    }

}
