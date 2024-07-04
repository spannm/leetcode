package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2378. Choose Edges to Maximize Score in a Tree.
 */
class Problem2378 extends LeetcodeProblem {

    private List<int[]>[] g;

    long maxScore(int[][] _edges) {
        int len = _edges.length;
        @SuppressWarnings("unchecked")
        List<int[]>[] lists = new List[len];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < len; i++) {
            int p = _edges[i][0];
            int w = _edges[i][1];
            g[p].add(new int[] {i, w});
        }
        return dfs(0)[1];
    }

    long[] dfs(int _i) {
        long a = 0;
        long b = 0;
        long t = 0;
        for (int[] nxt : g[_i]) {
            int j = nxt[0];
            int w = nxt[1];
            long[] s = dfs(j);
            a += s[1];
            b += s[1];
            t = Math.max(t, s[0] - s[1] + w);
        }
        b += t;
        return new long[] {a, b};
    }

}
