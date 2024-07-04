package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2858. Minimum Edge Reversals So Every Node Is Reachable.
 */
class Problem2858 extends LeetcodeProblem {

    private List<int[]>[] g;
    private int[]         ans;

    int[] minEdgeReversals(int _n, int[][] _edges) {
        @SuppressWarnings("unchecked")
        List<int[]>[] lists = new List[_n];
        g = lists;
        ans = new int[_n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : _edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(new int[] {y, 1});
            g[y].add(new int[] {x, -1});
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int _i, int _fa) {
        for (var ne : g[_i]) {
            int j = ne[0];
            int k = ne[1];
            if (j != _fa) {
                ans[0] += k < 0 ? 1 : 0;
                dfs(j, _i);
            }
        }
    }

    private void dfs2(int _i, int _fa) {
        for (var ne : g[_i]) {
            int j = ne[0];
            int k = ne[1];
            if (j != _fa) {
                ans[j] = ans[_i] + k;
                dfs2(j, _i);
            }
        }
    }

}
