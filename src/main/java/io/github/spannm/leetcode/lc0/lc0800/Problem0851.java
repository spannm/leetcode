package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 851. Loud and Rich.
 */
class Problem0851 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           quiet;
    private int[]           ans;

    int[] loudAndRich(int[][] _richer, int[] _quiet) {
        int n = _quiet.length;
        quiet = _quiet;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        ans = new int[n];
        Arrays.fill(ans, -1);
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var r : _richer) {
            g[r[1]].add(r[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int _i) {
        if (ans[_i] != -1) {
            return;
        }
        ans[_i] = _i;
        for (int j : g[_i]) {
            dfs(j);
            if (quiet[ans[j]] < quiet[ans[_i]]) {
                ans[_i] = ans[j];
            }
        }
    }

}
