package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1388 extends LeetcodeProblem {

    int maxSizeSlices(int[] _slices) {
        int n = _slices.length;
        int[] b = Arrays.copyOf(_slices, 2 * n);
        System.arraycopy(_slices, 0, b, n, n);
        int[][] dp = new int[2 * n][2 * n];
        for (int len = 3; len <= n; len += 3) {
            for (int i = 0; i + len - 1 < 2 * n; i++) {
                int j = i + len - 1;
                for (int k = i + 3; k <= j - 2; k += 3) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k][j]);
                }
                for (int k = i + 1; k < j; k += 3) {
                    dp[i][j] = Math.max(dp[i][j],
                        (i + 1 <= k - 1 ? dp[i + 1][k - 1] : 0)
                            + b[k] + (k + 1 <= j - 1 ? dp[k + 1][j - 1] : 0));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][i + n - 1]);
        }
        return ans;
    }

}
