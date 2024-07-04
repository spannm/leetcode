package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0552 extends LeetcodeProblem {

    int checkRecord(int _n) {
        final int mod = 1000000007;
        int[][][] f = new int[_n + 1][2][3];

        f[0] = new int[][] {{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= _n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2];
                    if (j > 0) {
                        val = (val + f[i - 1][j - 1][2]) % mod;
                    }
                    if (k > 0) {
                        val = (val + f[i - 1][j][k - 1]) % mod;
                    }
                    f[i][j][k] = val;
                }
            }
        }
        return f[_n][1][2];
    }

}
