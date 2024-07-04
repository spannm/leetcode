package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0313 extends LeetcodeProblem {

    int nthSuperUglyNumber(int _n, int[] _primes) {
        long[] ret = new long[_n];
        ret[0] = 1;

        int nbPrimes = _primes.length;
        int[] indexes = new int[nbPrimes];

        for (int i = 1; i < _n; i++) {
            ret[i] = Integer.MAX_VALUE;

            for (int j = 0; j < nbPrimes; j++) {
                ret[i] = Math.min(ret[i], _primes[j] * ret[indexes[j]]);
            }

            for (int j = 0; j < indexes.length; j++) {
                if (ret[i] == _primes[j] * ret[indexes[j]]) {
                    indexes[j]++;
                }
            }
        }
        return (int) ret[_n - 1];
    }

}
