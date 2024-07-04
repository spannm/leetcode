package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2925. Maximum Score After Applying Operations on a Tree.
 */
class Problem2925 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           values;

    long maximumScoreAfterOperations(int[][] _edges, int[] _values) {
        int n = _values.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        values = _values;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        return dfs(0, -1)[1];
    }

    private long[] dfs(int i, int fa) {
        long a = 0;
        long b = 0;
        boolean leaf = true;
        for (int j : g[i]) {
            if (j != fa) {
                leaf = false;
                var t = dfs(j, i);
                a += t[0];
                b += t[1];
            }
        }
        if (leaf) {
            return new long[] {values[i], 0};
        }
        return new long[] {values[i] + a, Math.max(values[i] + b, a)};
    }

}
