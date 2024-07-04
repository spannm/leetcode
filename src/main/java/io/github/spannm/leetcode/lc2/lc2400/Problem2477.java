package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2477. Minimum Fuel Cost to Report to the Capital.
 */
class Problem2477 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int             seats;
    private long            ans;

    long minimumFuelCost(int[][] _roads, int _seats) {
        int n = _roads.length + 1;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        seats = _seats;
        for (var e : _roads) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int _a, int _fa) {
        int sz = 1;
        for (int b : g[_a]) {
            if (b != _fa) {
                int t = dfs(b, _a);
                ans += (t + seats - 1) / seats;
                sz += t;
            }
        }
        return sz;
    }

}
