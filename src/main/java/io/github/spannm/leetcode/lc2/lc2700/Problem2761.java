package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2761. Prime Pairs With Target Sum.
 */
class Problem2761 extends LeetcodeProblem {

    List<List<Integer>> findPrimePairs(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;
            if (primes[x] && primes[y]) {
                ans.add(List.of(x, y));
            }
        }
        return ans;
    }

}
