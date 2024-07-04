package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 1632. Rank Transform of a Matrix.
 */
class Problem1632 extends LeetcodeProblem {

    int[][] matrixRankTransform(int[][] _matrix) {
        int nbRows = _matrix.length;
        int nbCols = _matrix[0].length;
        TreeMap<Integer, List<int[]>> d = new TreeMap<>();
        for (int r = 0; r < nbRows; r++) {
            for (int c = 0; c < nbCols; c++) {
                d.computeIfAbsent(_matrix[r][c], k -> new ArrayList<>()).add(new int[] {r, c});
            }
        }
        int[] rowMax = new int[nbRows];
        int[] colMax = new int[nbCols];
        int[][] ans = new int[nbRows][nbCols];
        UnionFind uf = new UnionFind(nbRows + nbCols);
        int[] rank = new int[nbRows + nbCols];
        for (var ps : d.values()) {
            for (var p : ps) {
                uf.union(p[0], p[1] + nbRows);
            }
            for (var p : ps) {
                int i = p[0];
                int j = p[1];
                rank[uf.find(i)] = Math.max(rank[uf.find(i)], Math.max(rowMax[i], colMax[j]));
            }
            for (var p : ps) {
                int i = p[0];
                int j = p[1];
                ans[i][j] = 1 + rank[uf.find(i)];
                rowMax[i] = ans[i][j];
                colMax[j] = ans[i][j];
            }
            for (var p : ps) {
                uf.reset(p[0]);
                uf.reset(p[1] + nbRows);
            }
        }
        return ans;
    }

    static class UnionFind {
        private final int[] p;
        private final int[] size;

        UnionFind(int _n) {
            p = new int[_n];
            size = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int _x) {
            if (p[_x] != _x) {
                p[_x] = find(p[_x]);
            }
            return p[_x];
        }

        void union(int _a, int _b) {
            int pa = find(_a);
            int pb = find(_b);
            if (pa != pb) {
                if (size[pa] > size[pb]) {
                    p[pb] = pa;
                    size[pa] += size[pb];
                } else {
                    p[pa] = pb;
                    size[pb] += size[pa];
                }
            }
        }

        void reset(int _x) {
            p[_x] = _x;
            size[_x] = 1;
        }

    }

}
