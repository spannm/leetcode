package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2152. Minimum Number of Lines to Cover Points.
 */
class Problem2152 extends LeetcodeProblem {

    private int[][] points;
    private int     nbPoints;
    private int[]   f;

    int minimumLines(int[][] _points) {
        points = _points;
        nbPoints = _points.length;
        f = new int[1 << nbPoints];
        return dfs(0);
    }

    private int dfs(int state) {
        if (state == (1 << nbPoints) - 1) {
            return 0;
        }
        if (f[state] != 0) {
            return f[state];
        }
        int ans = 1 << 30;
        for (int i = 0; i < nbPoints; i++) {
            if ((state >> i & 1) == 0) {
                for (int j = i + 1; j < nbPoints; j++) {
                    int nxt = state | 1 << i | 1 << j;
                    for (int k = j + 1; k < nbPoints; k++) {
                        if ((state >> k & 1) == 0 && check(i, j, k)) {
                            nxt |= 1 << k;
                        }
                    }
                    ans = Math.min(ans, dfs(nxt) + 1);
                }
                if (i == nbPoints - 1) {
                    ans = Math.min(ans, dfs(state | 1 << i) + 1);
                }
            }
        }
        return f[state] = ans;
    }

    private boolean check(int i, int j, int k) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        int x3 = points[k][0];
        int y3 = points[k][1];
        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

}
