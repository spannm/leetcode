package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">1232. Check If It Is a Straight Line</a>.
 */
class Problem1232 extends LeetcodeProblem {

    boolean checkStraightLine(int[][] _co) {
        final int len = _co.length;
        if (len == 2) {
            return true;
        }

        int x0 = _co[0][0];
        int y0 = _co[0][1];
        int x1 = _co[1][0];
        int y1 = _co[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int i = 2; i < len; i++) {
            int x = _co[i][0];
            int y = _co[i][1];
            if (dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }
        return true;
    }

}
