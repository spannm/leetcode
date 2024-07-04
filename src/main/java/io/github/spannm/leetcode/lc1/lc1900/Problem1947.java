package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1947. Maximum Compatibility Score Sum.
 */
class Problem1947 extends LeetcodeProblem {

    private int[][]   g;
    private boolean[] vis;
    private int       m;
    private int       ans;

    int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        g = new int[m][m];
        vis = new boolean[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < students[i].length; k++) {
                    g[i][j] += students[i][k] == mentors[j][k] ? 1 : 0;
                }
            }
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int t) {
        if (i == m) {
            ans = Math.max(ans, t);
            return;
        }
        for (int j = 0; j < m; j++) {
            if (!vis[j]) {
                vis[j] = true;
                dfs(i + 1, t + g[i][j]);
                vis[j] = false;
            }
        }
    }

}
