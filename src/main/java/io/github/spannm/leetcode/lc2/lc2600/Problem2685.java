package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2685. Count the Number of Complete Components.
 */
class Problem2685 extends LeetcodeProblem {

    private List<Integer>[] g;
    private boolean[]       vis;

    int countCompleteComponents(int _n, int[][] _edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        vis = new boolean[_n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        for (int i = 0; i < _n; i++) {
            if (!vis[i]) {
                int[] t = dfs(i);
                if (t[0] * (t[0] - 1) == t[1]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    int[] dfs(int _i) {
        vis[_i] = true;
        int x = 1;
        int y = g[_i].size();
        for (int j : g[_i]) {
            if (!vis[j]) {
                int[] t = dfs(j);
                x += t[0];
                y += t[1];
            }
        }
        return new int[] {x, y};
    }

}
