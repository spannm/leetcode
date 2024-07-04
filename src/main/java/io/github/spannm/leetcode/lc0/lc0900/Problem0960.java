package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 960. Delete Columns to Make Sorted III.
 */
class Problem0960 extends LeetcodeProblem {

    int minDeletionSize(String[] _strs) {
        int n = _strs[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int mx = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (check(i, j, _strs)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            mx = Math.max(mx, dp[i]);
        }
        return n - mx;
    }

    private boolean check(int _i, int _j, String[] _strs) {
        for (String s : _strs) {
            if (s.charAt(_i) < s.charAt(_j)) {
                return false;
            }
        }
        return true;
    }

}
