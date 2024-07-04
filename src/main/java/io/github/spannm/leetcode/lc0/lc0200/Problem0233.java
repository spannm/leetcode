package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0233 extends LeetcodeProblem {

    int countDigitOne(int _n) {
        int count = 0;
        for (long k = 1; k <= _n; k *= 10) {
            long r = _n / k;
            long m = _n % k;

            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }

}
