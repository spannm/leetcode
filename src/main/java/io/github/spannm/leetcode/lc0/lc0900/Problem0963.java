package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 963. Minimum Area Rectangle II.
 */
class Problem0963 extends LeetcodeProblem {

    double minAreaFreeRect(int[][] _points) {
        int n = _points.length;
        Set<Integer> s = new HashSet<>(n);
        for (int[] p : _points) {
            s.add(f(p[0], p[1]));
        }
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x1 = _points[i][0];
            int y1 = _points[i][1];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    int x2 = _points[j][0];
                    int y2 = _points[j][1];
                    for (int k = j + 1; k < n; k++) {
                        if (k != i) {
                            int x3 = _points[k][0];
                            int y3 = _points[k][1];
                            int x4 = x2 - x1 + x3;
                            int y4 = y2 - y1 + y3;
                            if (s.contains(f(x4, y4))) {
                                if ((x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0) {
                                    int ww = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                                    int hh = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1);
                                    ans = Math.min(ans, Math.sqrt((long) ww * hh));
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans == Double.MAX_VALUE ? 0 : ans;
    }

    private int f(int _x, int _y) {
        return _x * 40001 + _y;
    }

}
