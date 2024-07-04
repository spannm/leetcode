package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.GridMaster;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1810. Minimum Path Cost in a Hidden Grid.
 */
class Problem1810 extends LeetcodeProblem {

    private static final char[]  DIR  = {'U', 'R', 'D', 'L'};
    private static final char[]  NDIR = {'D', 'L', 'U', 'R'};
    private static final int[]   DIRS = {-1, 0, 1, 0, -1};
    private static final int     N    = 200;
    private static final int     INF  = 0x3f3f3f3f;
    private static final int[][] G    = new int[N][N];
    private static final int[][] DIST = new int[N][N];
    private int[]                target;

    int findShortestPath(GridMaster _master) {
        target = new int[] {-1, -1};
        for (int i = 0; i < N; i++) {
            Arrays.fill(G[i], -1);
            Arrays.fill(DIST[i], INF);
        }
        dfs(100, 100, _master);
        if (target[0] == -1 && target[1] == -1) {
            return -1;
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, 100, 100});
        DIST[100][100] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int w = p[0];
            int i = p[1];
            int j = p[2];
            if (i == target[0] && j == target[1]) {
                return w;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + DIRS[k];
                int y = j + DIRS[k + 1];
                if (x >= 0 && x < N && y >= 0 && y < N && G[x][y] != -1
                    && DIST[x][y] > w + G[x][y]) {
                    DIST[x][y] = w + G[x][y];
                    q.offer(new int[] {DIST[x][y], x, y});
                }
            }
        }
        return 0;
    }

    private void dfs(int i, int j, GridMaster master) {
        if (master.isTarget()) {
            target = new int[] {i, j};
        }
        for (int k = 0; k < 4; k++) {
            char d = DIR[k];
            char nd = NDIR[k];
            int x = i + DIRS[k];
            int y = j + DIRS[k + 1];
            if (x >= 0 && x < N && y >= 0 && y < N && master.canMove(d) && G[x][y] == -1) {
                G[x][y] = master.move(d);
                dfs(x, y, master);
                master.move(nd);
            }
        }
    }

}
