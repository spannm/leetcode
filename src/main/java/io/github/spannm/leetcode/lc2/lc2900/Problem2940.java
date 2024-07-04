package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2940. Find Building Where Alice and Bob Can Meet.
 */
class Problem2940 extends LeetcodeProblem {

    int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        for (int i = 0; i < m; i++) {
            if (queries[i][0] > queries[i][1]) {
                queries[i] = new int[] {queries[i][1], queries[i][0]};
            }
        }
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][1] - queries[i][1]);
        int[] s = heights.clone();
        Arrays.sort(s);
        int[] ans = new int[m];
        int j = n - 1;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i : idx) {
            int l = queries[i][0];
            int r = queries[i][1];
            while (j > r) {
                int k = n - Arrays.binarySearch(s, heights[j]) + 1;
                tree.update(k, j);
                j--;
            }
            if (l == r || heights[l] < heights[r]) {
                ans[i] = r;
            } else {
                int k = n - Arrays.binarySearch(s, heights[l]);
                ans[i] = tree.query(k);
            }
        }
        return ans;
    }

    static class BinaryIndexedTree {
        private final int   inf = 1 << 30;
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
            Arrays.fill(c, inf);
        }

        void update(int _x, int _v) {
            while (_x <= n) {
                c[_x] = Math.min(c[_x], _v);
                _x += _x & -_x;
            }
        }

        int query(int _x) {
            int mi = inf;
            while (_x > 0) {
                mi = Math.min(mi, c[_x]);
                _x -= _x & -_x;
            }
            return mi == inf ? -1 : mi;
        }

    }
}
