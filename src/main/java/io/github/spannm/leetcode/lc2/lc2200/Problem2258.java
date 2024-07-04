package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2258. Escape the Spreading Fire.
 */
class Problem2258 extends LeetcodeProblem {

    private int[][]     grid;
    private int         nbRows;
    private int         nbCols;
    private boolean[][] fire;
    private boolean[][] vis;
    private final int[] dirs = {-1, 0, 1, 0, -1};

    int maximumMinutes(int[][] _grid) {
        grid = _grid;
        nbRows = _grid.length;
        nbCols = _grid[0].length;
        fire = new boolean[nbRows][nbCols];
        vis = new boolean[nbRows][nbCols];
        int l = -1;
        int r = nbRows * nbCols;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l == nbRows * nbCols ? 1000000000 : l;
    }

    boolean check(int _t) {
        for (int i = 0; i < nbRows; i++) {
            Arrays.fill(fire[i], false);
            Arrays.fill(vis[i], false);
        }
        Deque<int[]> q1 = new ArrayDeque<>();
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                if (grid[i][j] == 1) {
                    q1.offer(new int[] {i, j});
                    fire[i][j] = true;
                }
            }
        }
        for (; _t > 0 && !q1.isEmpty(); _t--) {
            q1 = spread(q1);
        }
        if (fire[0][0]) {
            return false;
        }
        Deque<int[]> q2 = new ArrayDeque<>();
        q2.offer(new int[] {0, 0});
        vis[0][0] = true;
        for (; !q2.isEmpty(); q1 = spread(q1)) {
            for (int d = q2.size(); d > 0; d--) {
                int[] p = q2.poll();
                if (fire[p[0]][p[1]]) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int x = p[0] + dirs[k];
                    int y = p[1] + dirs[k + 1];
                    if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && !fire[x][y] && !vis[x][y]
                        && grid[x][y] == 0) {
                        if (x == nbRows - 1 && y == nbCols - 1) {
                            return true;
                        }
                        vis[x][y] = true;
                        q2.offer(new int[] {x, y});
                    }
                }
            }
        }
        return false;
    }

    private Deque<int[]> spread(Deque<int[]> q) {
        Deque<int[]> nq = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = p[0] + dirs[k];
                int y = p[1] + dirs[k + 1];
                if (x >= 0 && x < nbRows && y >= 0 && y < nbCols && !fire[x][y] && grid[x][y] == 0) {
                    fire[x][y] = true;
                    nq.offer(new int[] {x, y});
                }
            }
        }
        return nq;
    }

}
