package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2246. Longest Path With Different Adjacent Characters.
 */
class Problem2246 extends LeetcodeProblem {

    private List<Integer>[] g;
    private String          s;
    private int             ans;

    int longestPath(int[] _parent, String _s) {
        s = _s;
        int n = _parent.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[_parent[i]].add(i);
        }
        dfs(0);
        return ans + 1;
    }

    private int dfs(int i) {
        int mx = 0;
        for (int j : g[i]) {
            int x = dfs(j) + 1;
            if (s.charAt(i) != s.charAt(j)) {
                ans = Math.max(ans, mx + x);
                mx = Math.max(mx, x);
            }
        }
        return mx;
    }

}
