package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 2814. Minimum Time Takes to Reach Destination Without Drowning.
 */
class Problem2814 extends LeetcodeProblem {

    int minimumSeconds(List<List<String>> land) {
        int m = land.size();
        int n = land.get(0).size();
        boolean[][] vis = new boolean[m][n];
        int[][] g = new int[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        int si = 0;
        int sj = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(g[i], 1 << 30);
            for (int j = 0; j < n; j++) {
                String c = land.get(i).get(j);
                if ("*".equals(c)) {
                    q.offer(new int[] {i, j});
                } else if ("S".equals(c)) {
                    si = i;
                    sj = j;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int t = 0; !q.isEmpty(); t++) {
            for (int k = q.size(); k > 0; k--) {
                int[] p = q.poll();
                int i = p[0];
                int j = p[1];
                g[i][j] = t;
                for (int d = 0; d < 4; d++) {
                    int x = i + dirs[d];
                    int y = j + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y]) {
                        boolean empty = ".".equals(land.get(x).get(y));
                        boolean start = "S".equals(land.get(x).get(y));
                        if (empty || start) {
                            vis[x][y] = true;
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        q.offer(new int[] {si, sj});
        vis = new boolean[m][n];
        vis[si][sj] = true;
        for (int t = 0; !q.isEmpty(); t++) {
            for (int k = q.size(); k > 0; k--) {
                int[] p = q.poll();
                int i = p[0];
                int j = p[1];
                if ("D".equals(land.get(i).get(j))) {
                    return t;
                }
                for (int d = 0; d < 4; d++) {
                    int x = i + dirs[d];
                    int y = j + dirs[d + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && g[x][y] > t + 1) {
                        boolean empty = ".".equals(land.get(x).get(y));
                        boolean dest = "D".equals(land.get(x).get(y));
                        if (empty || dest) {
                            vis[x][y] = true;
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return -1;
    }

}
