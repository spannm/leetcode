package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3004. Maximum Subtree of the Same Color.
 */
class Problem3004 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           colors;
    private int[]           size;
    private int             ans;

    @SuppressWarnings("unchecked")
    int maximumSubtreeSize(int[][] _edges, int[] _colors) {
        int n = _edges.length + 1;
        g = new List[n];
        size = new int[n];
        colors = _colors;
        Arrays.fill(size, 1);
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private boolean dfs(int _a, int _fa) {
        boolean ok = true;
        for (int b : g[_a]) {
            if (b != _fa) {
                boolean t = dfs(b, _a);
                ok = ok && colors[_a] == colors[b] && t;
                size[_a] += size[b];
            }
        }
        if (ok) {
            ans = Math.max(ans, size[_a]);
        }
        return ok;
    }

}
