package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0474 extends LeetcodeProblem {

    int findMaxForm(String[] _strs, int _m, int _n) {
        int[][] dp = new int[_m + 1][_n + 1];
        for (String str : _strs) {
            int[] count = count(str);
            for (int i = _m; i >= count[0]; i--) {
                for (int j = _n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[_m][_n];
    }

    static int[] count(String _str) {
        int[] res = new int[2];
        for (int i = 0; i < _str.length(); i++) {
            res[_str.charAt(i) - '0']++;
        }
        return res;
    }

}
