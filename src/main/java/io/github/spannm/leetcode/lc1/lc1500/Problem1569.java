package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/">1569. Number of Ways to
 * Reorder Array to Get Same BST</a>.
 */
class Problem1569 extends LeetcodeProblem {

    private static final int MOD = 1000000007;

    static int numOfWays(final int[] _nums) {
        final int sz = _nums.length;
        if (sz <= 2) {
            return 0;
        }
        return countWays(Arrays.stream(_nums).boxed().toList(), sz) - 1;
    }

    private static int countWays(final List<Integer> _nums, final int _size) {
        if (_size <= 2) {
            return 1;
        }

        final List<Integer> left = new ArrayList<>();
        final List<Integer> right = new ArrayList<>();
        int root = _nums.get(0);

        for (int i = 1; i < _size; i++) {
            if (_nums.get(i) < root) {
                left.add(_nums.get(i));
            } else {
                right.add(_nums.get(i));
            }
        }

        long countLeft = countWays(left, left.size());
        long countRight = countWays(right, right.size());

        return (int) (comb(_size - 1, left.size()) % MOD * (countLeft % MOD) % MOD * (countRight % MOD) % MOD);
    }

    private static long comb(final int _n, final int _k) {
        final long[][] dp = new long[_n + 1][_k + 1];
        for (int i = 0; i <= _n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, _k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        return dp[_n][_k];
    }

}
