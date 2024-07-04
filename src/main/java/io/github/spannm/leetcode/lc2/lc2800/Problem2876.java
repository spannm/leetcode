package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2876. Count Visited Nodes in a Directed Graph.
 */
class Problem2876 extends LeetcodeProblem {

    int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] ans = new int[n];
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                int cnt = 0;
                int j = i;
                while (vis[j] == 0) {
                    vis[j] = ++cnt;
                    j = edges.get(j);
                }
                int cycle = 0;
                int total = cnt + ans[j];
                if (ans[j] == 0) {
                    cycle = cnt - vis[j] + 1;
                }
                j = i;
                while (ans[j] == 0) {
                    ans[j] = Math.max(total--, cycle);
                    j = edges.get(j);
                }
            }
        }
        return ans;
    }

}
