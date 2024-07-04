package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1617. Count Subtrees With Max Distance Between Cities.
 */
class Problem1617 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int             msk;
    private int             nxt;
    private int             mx;

    int[] countSubgraphsForEachDiameter(int _n, int[][] _edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : _edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] ans = new int[_n - 1];
        for (int mask = 1; mask < 1 << _n; ++mask) {
            if ((mask & mask - 1) == 0) {
                continue;
            }
            msk = mask;
            mx = 0;
            int cur = 31 - Integer.numberOfLeadingZeros(msk);
            dfs(cur, 0);
            if (msk == 0) {
                msk = mask;
                mx = 0;
                dfs(nxt, 0);
                ++ans[mx - 1];
            }
        }
        return ans;
    }

    private void dfs(int u, int d) {
        msk ^= 1 << u;
        if (mx < d) {
            mx = d;
            nxt = u;
        }
        for (int v : g[u]) {
            if ((msk >> v & 1) == 1) {
                dfs(v, d + 1);
            }
        }
    }

}
