package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1129. Shortest Path with Alternating Colors.
 */
class Problem1129 extends LeetcodeProblem {

    int[] shortestAlternatingPaths(int _n, int[][] _redEdges, int[][] _blueEdges) {
        @SuppressWarnings("unchecked")
        List<Integer>[][] g = new List[2][_n];
        for (var f : g) {
            Arrays.setAll(f, k -> new ArrayList<>());
        }
        for (var e : _redEdges) {
            g[0][e[0]].add(e[1]);
        }
        for (var e : _blueEdges) {
            g[1][e[0]].add(e[1]);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        q.offer(new int[] {0, 1});
        boolean[][] vis = new boolean[_n][2];
        int[] ans = new int[_n];
        Arrays.fill(ans, -1);
        int d = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                var p = q.poll();
                int i = p[0];
                int c = p[1];
                if (ans[i] == -1) {
                    ans[i] = d;
                }
                vis[i][c] = true;
                c ^= 1;
                for (int j : g[c][i]) {
                    if (!vis[j][c]) {
                        q.offer(new int[] {j, c});
                    }
                }
            }
            d++;
        }
        return ans;
    }

}
