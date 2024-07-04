package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.math.BigInteger;
import java.util.Arrays;

class Problem1175 extends LeetcodeProblem {

    static final int MOD = 1000000007;

    static int numPrimeArrangements(int _n) {
        int numberOfPrimes = generatePrimes(_n);
        BigInteger x = factorial(numberOfPrimes);
        BigInteger y = factorial(_n - numberOfPrimes);
        return x.multiply(y).mod(BigInteger.valueOf(MOD)).intValue();
    }

    static BigInteger factorial(int _n) {
        BigInteger fac = BigInteger.ONE;
        for (int i = 2; i <= _n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac.mod(BigInteger.valueOf(MOD));
    }

    static int generatePrimes(int _n) {
        boolean[] prime = new boolean[_n + 1];
        Arrays.fill(prime, 2, _n + 1, true);
        for (int i = 2; i * i <= _n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= _n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean element : prime) {
            if (element) {
                count++;
            }
        }

        return count;
    }

}
