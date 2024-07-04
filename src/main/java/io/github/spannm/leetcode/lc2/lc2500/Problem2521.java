package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2521. Distinct Prime Factors of Product of Array.
 */
class Problem2521 extends LeetcodeProblem {

    int distinctPrimeFactors(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) {
            for (int i = 2; i <= n / i; i++) {
                if (n % i == 0) {
                    s.add(i);
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            if (n > 1) {
                s.add(n);
            }
        }
        return s.size();
    }

}
