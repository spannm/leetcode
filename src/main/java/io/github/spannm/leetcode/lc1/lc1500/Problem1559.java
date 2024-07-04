package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1559. Detect Cycles in 2D Grid.
 */
class Problem1559 extends LeetcodeProblem {

    private int[] p;

    boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        int[] dirs = {0, 1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    int x = i + dirs[k];
                    int y = j + dirs[k + 1];
                    if (x < m && y < n && grid[i][j] == grid[x][y]) {
                        if (find(x * n + y) == find(i * n + j)) {
                            return true;
                        }
                        p[find(x * n + y)] = find(i * n + j);
                    }
                }
            }
        }
        return false;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

}
