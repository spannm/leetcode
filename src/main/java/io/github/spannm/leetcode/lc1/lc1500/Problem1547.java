package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/">1547. Minimum Cost to Cut a Stick</a>.
 */
class Problem1547 extends LeetcodeProblem {

    static int minCost(int _n, int[] _cuts) {
        // add two sentinel values to cuts: left and right edges of the stick
        final int len = _cuts.length + 2;
        final int[] cuts = Arrays.copyOf(_cuts, len);
        cuts[len - 1] = _n;
        Arrays.sort(cuts);

        final int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                        cuts[j] - cuts[i] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
