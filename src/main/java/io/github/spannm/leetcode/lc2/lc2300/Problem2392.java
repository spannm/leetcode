package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2392. Build a Matrix With Conditions.
 */
class Problem2392 extends LeetcodeProblem {

    private int k;

    int[][] buildMatrix(int _k, int[][] _rowConditions, int[][] _colConditions) {
        k = _k;
        List<Integer> row = f(_rowConditions);
        List<Integer> col = f(_colConditions);
        if (row == null || col == null) {
            return new int[0][0];
        }
        int[][] ans = new int[_k][_k];
        int[] m = new int[_k + 1];
        for (int i = 0; i < _k; i++) {
            m[col.get(i)] = i;
        }
        for (int i = 0; i < _k; i++) {
            ans[i][m[row.get(i)]] = row.get(i);
        }
        return ans;
    }

    List<Integer> f(int[][] _cond) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[k + 1];
        Arrays.setAll(g, key -> new ArrayList<>());
        int[] indeg = new int[k + 1];
        for (var e : _cond) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            indeg[b]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; n--) {
                int i = q.pollFirst();
                res.add(i);
                for (int j : g[i]) {
                    if (--indeg[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }
        return res.size() == k ? res : null;
    }

}
