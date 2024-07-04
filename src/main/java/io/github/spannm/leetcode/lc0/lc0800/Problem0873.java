package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. Length of Longest Fibonacci Subsequence.
 */
class Problem0873 extends LeetcodeProblem {

    int lenLongestFibSubseq(int[] _arr) {
        int n = _arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(_arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[j][i] = 2;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int d = _arr[i] - _arr[j];
                if (mp.containsKey(d)) {
                    int k = mp.get(d);
                    if (k < j) {
                        dp[j][i] = Math.max(dp[j][i], dp[k][j] + 1);
                        ans = Math.max(ans, dp[j][i]);
                    }
                }
            }
        }
        return ans;
    }

}
