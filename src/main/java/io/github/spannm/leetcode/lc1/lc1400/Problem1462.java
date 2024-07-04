package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1462. Course Schedule IV.
 */
class Problem1462 extends LeetcodeProblem {

    List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] f = new boolean[n][n];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[n];
        int[] indeg = new int[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var p : prerequisites) {
            g[p[0]].add(p[1]);
            indeg[p[1]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : g[i]) {
                f[i][j] = true;
                for (int h = 0; h < n; h++) {
                    f[h][j] |= f[h][i];
                }
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] qry : queries) {
            boolean b = f[qry[0]][qry[1]];
            ans.add(b);
        }
        return ans;
    }

}
