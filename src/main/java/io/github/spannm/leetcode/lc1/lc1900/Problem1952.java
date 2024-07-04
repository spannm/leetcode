package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1952 extends LeetcodeProblem {

    boolean isThree(int _n) {
        int divisors = 0;
        for (int i = 1; i <= _n; i++) {
            if (_n % i == 0) {
                divisors++;
            }
        }
        return divisors == 3;
    }

}
