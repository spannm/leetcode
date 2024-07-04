package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2242. Maximum Score of a Node Sequence.
 */
class Problem2242 extends LeetcodeProblem {

    int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            g[i].sort((a, b) -> scores[b] - scores[a]);
            g[i] = g[i].subList(0, Math.min(3, g[i].size()));
        }
        int ans = -1;
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            for (int c : g[a]) {
                for (int d : g[b]) {
                    if (c != b && c != d && a != d) {
                        int t = scores[a] + scores[b] + scores[c] + scores[d];
                        ans = Math.max(ans, t);
                    }
                }
            }
        }
        return ans;
    }

}
