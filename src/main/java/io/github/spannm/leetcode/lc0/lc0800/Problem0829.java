package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 829. Consecutive Numbers Sum.
 */
class Problem0829 extends LeetcodeProblem {

    int consecutiveNumbersSum(int _n) {
        _n <<= 1;
        int ans = 0;
        for (int k = 1; k * (k + 1) <= _n; k++) {
            if (_n % k == 0 && (_n / k + 1 - k) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
