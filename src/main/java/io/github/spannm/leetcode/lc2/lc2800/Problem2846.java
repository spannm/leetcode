package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2846. Minimum Edge Weight Equilibrium Queries in a Tree.
 */
class Problem2846 extends LeetcodeProblem {

    int[] minOperationsQueries(int _n, int[][] _edges, int[][] _queries) {
        int m = 32 - Integer.numberOfLeadingZeros(_n);
        @SuppressWarnings("unchecked")
        List<int[]>[] g = new List[_n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[][] f = new int[_n][m];
        int[] p = new int[_n];
        int[][] cnt = new int[_n][0];
        int[] depth = new int[_n];
        for (var e : _edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2] - 1;
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        cnt[0] = new int[26];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            f[i][0] = p[i];
            for (int j = 1; j < m; j++) {
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
            for (var nxt : g[i]) {
                int j = nxt[0];
                int w = nxt[1];
                if (j != p[i]) {
                    p[j] = i;
                    cnt[j] = cnt[i].clone();
                    cnt[j][w]++;
                    depth[j] = depth[i] + 1;
                    q.offer(j);
                }
            }
        }
        int k = _queries.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int u = _queries[i][0];
            int v = _queries[i][1];
            int x = u;
            int y = v;
            if (depth[x] < depth[y]) {
                int t = x;
                x = y;
                y = t;
            }
            for (int j = m - 1; j >= 0; j--) {
                if (depth[x] - depth[y] >= 1 << j) {
                    x = f[x][j];
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                if (f[x][j] != f[y][j]) {
                    x = f[x][j];
                    y = f[y][j];
                }
            }
            if (x != y) {
                x = p[x];
            }
            int mx = 0;
            for (int j = 0; j < 26; j++) {
                mx = Math.max(mx, cnt[u][j] + cnt[v][j] - 2 * cnt[x][j]);
            }
            ans[i] = depth[u] + depth[v] - 2 * depth[x] - mx;
        }
        return ans;
    }

}
