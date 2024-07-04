package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0204 extends LeetcodeProblem {

    int countPrimes(int _n) {
        boolean[] notPrime = new boolean[_n];
        int count = 0;
        for (int i = 2; i < _n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < _n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

}
