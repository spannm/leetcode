package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1043 extends LeetcodeProblem {

    int maxSumAfterPartitioning(int[] _arr, int _k) {
        final int len = _arr.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int curMax = 0;
            for (int k = 1; k <= _k && i - k + 1 >= 0; k++) {
                curMax = Math.max(curMax, _arr[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[len - 1];
    }

}
