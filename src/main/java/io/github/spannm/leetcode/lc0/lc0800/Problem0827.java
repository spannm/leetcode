package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 827. Making A Large Island.
 */
class Problem0827 extends LeetcodeProblem {

    private static final int[] DIRS = new int[] {-1, 0, 1, 0, -1};

    private int[]              p;
    private int                ans  = 1;

    int largestIsland(int[][] _grid) {
        int n = _grid.length;
        p = new int[n * n];
        int[] size = new int[n * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (_grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + DIRS[k];
                        int y = j + DIRS[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < n && _grid[x][y] == 1) {
                            int pa = find(x * n + y);
                            int pb = find(i * n + j);
                            if (pa == pb) {
                                continue;
                            }
                            p[pa] = pb;
                            size[pb] += size[pa];
                            ans = Math.max(ans, size[pb]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (_grid[i][j] == 0) {
                    int t = 1;
                    Set<Integer> vis = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int x = i + DIRS[k];
                        int y = j + DIRS[k + 1];
                        if (x >= 0 && x < n && y >= 0 && y < n && _grid[x][y] == 1) {
                            int root = find(x * n + y);
                            if (!vis.contains(root)) {
                                vis.add(root);
                                t += size[root];
                            }
                        }
                    }
                    ans = Math.max(ans, t);
                }
            }
        }
        return ans;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
