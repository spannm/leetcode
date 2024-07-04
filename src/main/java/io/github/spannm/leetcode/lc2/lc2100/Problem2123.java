package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2123. Minimum Operations to Remove Adjacent Ones in Matrix.
 */
class Problem2123 extends LeetcodeProblem {

    private final Map<Integer, List<Integer>> g   = new HashMap<>();
    private final Set<Integer>                vis = new HashSet<>();
    private int[]                             match;

    int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 1 && grid[i][j] == 1) {
                    int x = i * n + j;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x + n);
                    }
                    if (i > 0 && grid[i - 1][j] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x - n);
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x + 1);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        g.computeIfAbsent(x, z -> new ArrayList<>()).add(x - 1);
                    }
                }
            }
        }
        match = new int[m * n];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i : g.keySet()) {
            ans += find(i);
            vis.clear();
        }
        return ans;
    }

    private int find(int i) {
        for (int j : g.get(i)) {
            if (vis.add(j)) {
                if (match[j] == -1 || find(match[j]) == 1) {
                    match[j] = i;
                    return 1;
                }
            }
        }
        return 0;
    }

}
