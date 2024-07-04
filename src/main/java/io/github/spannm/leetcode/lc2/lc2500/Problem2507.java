package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2507. Smallest Value After Replacing With Sum of Prime Factors.
 */
class Problem2507 extends LeetcodeProblem {

    int smallestValue(int n) {
        while (true) {
            int t = n;
            int s = 0;
            for (int i = 2; i <= n / i; i++) {
                while (n % i == 0) {
                    s += i;
                    n /= i;
                }
            }
            if (n > 1) {
                s += n;
            }
            if (s == t) {
                return s;
            }
            n = s;
        }
    }

}
