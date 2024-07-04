package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
 */
class Problem1414 extends LeetcodeProblem {

    int findMinFibonacciNumbers(int k) {
        if (k < 2) {
            return k;
        }
        int a = 1;
        int b = 1;
        while (b <= k) {
            b = a + b;
            a = b - a;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }

}
