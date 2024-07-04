package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1263. Minimum Moves to Move a Box to Their Target Location.
 */
class Problem1263 extends LeetcodeProblem {

    private char[][] grid;
    private int      nbRows;
    private int      nbCols;

    int minPushBox(char[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        int si = 0;
        int sj = 0;
        int bi = 0;
        int bj = 0;
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (_grid[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (_grid[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[nbRows * nbCols][nbRows * nbCols];
        q.offer(new int[] {f(si, sj), f(bi, bj), 0});
        vis[f(si, sj)][f(bi, bj)] = true;
        while (!q.isEmpty()) {
            var p = q.poll();
            int d = p[2];
            bi = p[1] / nbCols;
            bj = p[1] % nbCols;
            if (_grid[bi][bj] == 'T') {
                return d;
            }
            si = p[0] / nbCols;
            sj = p[0] % nbCols;
            for (int k = 0; k < 4; k++) {
                int sx = si + dirs[k];
                int sy = sj + dirs[k + 1];
                if (!check(sx, sy)) {
                    continue;
                }
                if (sx == bi && sy == bj) {
                    int bx = bi + dirs[k];
                    int by = bj + dirs[k + 1];
                    if (!check(bx, by) || vis[f(sx, sy)][f(bx, by)]) {
                        continue;
                    }
                    vis[f(sx, sy)][f(bx, by)] = true;
                    q.offer(new int[] {f(sx, sy), f(bx, by), d + 1});
                } else if (!vis[f(sx, sy)][f(bi, bj)]) {
                    vis[f(sx, sy)][f(bi, bj)] = true;
                    q.offerFirst(new int[] {f(sx, sy), f(bi, bj), d});
                }
            }
        }
        return -1;
    }

    private int f(int _i, int _j) {
        return _i * nbCols + _j;
    }

    private boolean check(int _i, int _j) {
        return _i >= 0 && _i < nbRows && _j >= 0 && _j < nbCols && grid[_i][_j] != '#';
    }

}
