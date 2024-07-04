package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 959. Regions Cut By Slashes.
 */
class Problem0959 extends LeetcodeProblem {

    private int[] p;
    private int   size;

    int regionsBySlashes(String[] _grid) {
        int n = _grid.length;
        size = n * n * 4;
        p = new int[size];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (i < n - 1) {
                    union(4 * k + 2, (k + n) * 4);
                }
                if (j < n - 1) {
                    union(4 * k + 1, (k + 1) * 4 + 3);
                }
                char v = _grid[i].charAt(j);
                if (v == '/') {
                    union(4 * k, 4 * k + 3);
                    union(4 * k + 1, 4 * k + 2);
                } else if (v == '\\') {
                    union(4 * k, 4 * k + 1);
                    union(4 * k + 2, 4 * k + 3);
                } else {
                    union(4 * k, 4 * k + 1);
                    union(4 * k + 1, 4 * k + 2);
                    union(4 * k + 2, 4 * k + 3);
                }
            }
        }
        return size;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

    private void union(int _a, int _b) {
        int pa = find(_a);
        int pb = find(_b);
        if (pa == pb) {
            return;
        }
        p[pa] = pb;
        size--;
    }

}
