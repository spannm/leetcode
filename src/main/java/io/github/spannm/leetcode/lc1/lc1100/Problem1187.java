package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/make-array-strictly-increasing/description/">1187. Make Array Strictly
 * Increasing</a>.
 */
class Problem1187 extends LeetcodeProblem {

    static int makeArrayIncreasing(final int[] _a, final int[] _b) {
        final TreeSet<Integer> set = new TreeSet<>(IntStream.of(_b).boxed().toList());
        final int blen = _b.length;
        final int[] dp = new int[blen + 1];
        dp[0] = -1;

        for (int k : _a) {
            for (int j = blen; j >= 0; j--) {
                int a = k > dp[j] ? k : Integer.MAX_VALUE; // option A - don't swap
                Integer b = set.higher(j == 0 ? Integer.MAX_VALUE : dp[j - 1]); // option B - swap
                dp[j] = Math.min(a, b == null ? Integer.MAX_VALUE : b); // take the min of A and B
            }
        }

        for (int i = 0; i <= blen; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return -1;
    }

}
