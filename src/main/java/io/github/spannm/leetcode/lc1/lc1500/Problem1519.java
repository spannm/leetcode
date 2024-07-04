package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1519. Number of Nodes in the Sub-Tree With the Same Label.
 */
class Problem1519 extends LeetcodeProblem {

    private List<Integer>[] g;
    private String          labels;
    private int[]           ans;
    private int[]           cnt;

    int[] countSubTrees(int _n, int[][] _edges, String _labels) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        labels = _labels;
        ans = new int[_n];
        cnt = new int[26];
        dfs(0, -1);
        return ans;
    }

    private void dfs(int i, int fa) {
        int k = labels.charAt(i) - 'a';
        ans[i] -= cnt[k];
        cnt[k]++;
        for (int j : g[i]) {
            if (j != fa) {
                dfs(j, i);
            }
        }
        ans[i] += cnt[k];
    }

}
