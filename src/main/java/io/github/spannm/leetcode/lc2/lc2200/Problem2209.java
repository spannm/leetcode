package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2209. Minimum White Tiles After Covering With Carpets.
 */
class Problem2209 extends LeetcodeProblem {

    private int[][] f;
    private int[]   s;
    private int     n;
    private int     k;

    int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        n = floor.length();
        f = new int[n][numCarpets + 1];
        for (var e : f) {
            Arrays.fill(e, -1);
        }
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + (floor.charAt(i) == '1' ? 1 : 0);
        }
        k = carpetLen;
        return dfs(0, numCarpets);
    }

    private int dfs(int i, int j) {
        if (i >= n) {
            return 0;
        }
        if (j == 0) {
            return s[n] - s[i];
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        if (s[i + 1] == s[i]) {
            return dfs(i + 1, j);
        }
        int ans = Math.min(1 + dfs(i + 1, j), dfs(i + k, j - 1));
        f[i][j] = ans;
        return ans;
    }

}
