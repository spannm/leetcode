package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2851. String Transformation.
 */
class Problem2851 extends LeetcodeProblem {

    private static final int M = 1000000007;

    private int add(int _x, int _y) {
        if ((_x += _y) >= M) {
            _x -= M;
        }
        return _x;
    }

    private int mul(long _x, long _y) {
        return (int) (_x * _y % M);
    }

    private int[] getZ(String _s) {
        int n = _s.length();
        int[] z = new int[n];
        for (int i = 1, left = 0, right = 0; i < n; i++) {
            if (i <= right && z[i - left] <= right - i) {
                z[i] = z[i - left];
            } else {
                int zi = Math.max(0, right - i + 1);
                while (i + zi < n && _s.charAt(i + zi) == _s.charAt(zi)) {
                    zi++;
                }
                z[i] = zi;
            }
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        return z;
    }

    private int[][] matrixMultiply(int[][] _a, int[][] _b) {
        int m = _a.length;
        int n = _a[0].length;
        int p = _b[0].length;
        int[][] r = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    r[i][j] = add(r[i][j], mul(_a[i][k], _b[k][j]));
                }
            }
        }
        return r;
    }

    private int[][] matrixPower(int[][] _a, long _y) {
        int n = _a.length;
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++) {
            r[i][i] = 1;
        }
        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(_a[i], 0, x[i], 0, n);
        }
        while (_y > 0) {
            if ((_y & 1) == 1) {
                r = matrixMultiply(r, x);
            }
            x = matrixMultiply(x, x);
            _y >>= 1;
        }
        return r;
    }

    int numberOfWays(String _s, String _t, long _k) {
        int n = _s.length();
        int[] dp = matrixPower(new int[][] {{0, 1}, {n - 1, n - 2}}, _k)[0];
        _s += _t + _t;
        int[] z = getZ(_s);
        int m = n + n;
        int result = 0;
        for (int i = n; i < m; i++) {
            if (z[i] >= n) {
                result = add(result, dp[i - n == 0 ? 0 : 1]);
            }
        }
        return result;
    }

}
