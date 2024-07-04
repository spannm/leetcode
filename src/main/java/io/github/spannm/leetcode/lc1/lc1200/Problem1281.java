package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1281 extends LeetcodeProblem {

    int subtractProductAndSum(int _n) {
        int sum = 0;
        int product = 1;
        while (_n > 0) {
            int digit = _n % 10;
            _n /= 10;
            sum += digit;
            product *= digit;
        }
        return product - sum;
    }

}
