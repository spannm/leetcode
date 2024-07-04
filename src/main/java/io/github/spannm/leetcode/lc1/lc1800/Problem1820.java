package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1820. Maximum Number of Accepted Invitations.
 */
class Problem1820 extends LeetcodeProblem {

    private int[][]   grid;
    private int       nbCols;
    private boolean[] vis;
    private int[]     match;

    int maximumInvitations(int[][] _grid) {
        grid = _grid;
        int nbRows = _grid.length;
        nbCols = _grid[0].length;
        vis = new boolean[nbCols];
        match = new int[nbCols];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i = 0; i < nbRows; i++) {
            Arrays.fill(vis, false);
            if (find(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean find(int i) {
        for (int j = 0; j < nbCols; j++) {
            if (grid[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                if (match[j] == -1 || find(match[j])) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

}
