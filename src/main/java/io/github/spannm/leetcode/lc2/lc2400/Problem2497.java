package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2497. Maximum Star Sum of a Graph.
 */
class Problem2497 extends LeetcodeProblem {

    int maxStarSum(int[] _vals, int[][] _edges, int _k) {
        int n = _vals.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, key -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            if (_vals[b] > 0) {
                g[a].add(_vals[b]);
            }
            if (_vals[a] > 0) {
                g[b].add(_vals[a]);
            }
        }
        for (var e : g) {
            e.sort((a, b) -> b - a);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int v = _vals[i];
            for (int j = 0; j < Math.min(g[i].size(), _k); j++) {
                v += g[i].get(j);
            }
            ans = Math.max(ans, v);
        }
        return ans;
    }

}
