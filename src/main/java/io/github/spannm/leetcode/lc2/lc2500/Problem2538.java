package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2538. Difference Between Maximum and Minimum Price Sum.
 */
class Problem2538 extends LeetcodeProblem {

    private List<Integer>[] g;
    private long            ans;
    private int[]           price;

    long maxOutput(int _n, int[][] _edges, int[] _price) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        price = _price;
        dfs(0, -1);
        return ans;
    }

    private long[] dfs(int i, int fa) {
        long a = price[i];
        long b = 0;
        for (int j : g[i]) {
            if (j != fa) {
                var e = dfs(j, i);
                long c = e[0];
                long d = e[1];
                ans = Math.max(ans, Math.max(a + d, b + c));
                a = Math.max(a, price[i] + c);
                b = Math.max(b, price[i] + d);
            }
        }
        return new long[] {a, b};
    }

}
