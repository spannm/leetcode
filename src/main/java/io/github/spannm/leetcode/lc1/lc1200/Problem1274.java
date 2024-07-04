package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1274. Number of Ships in a Rectangle.
 */
class Problem1274 extends LeetcodeProblem {

    int countShips(Sea _sea, int[] _topRight, int[] _bottomLeft) {
        int x1 = _bottomLeft[0];
        int y1 = _bottomLeft[1];
        int x2 = _topRight[0];
        int y2 = _topRight[1];
        if (x1 > x2 || y1 > y2 || !_sea.hasShips(_topRight, _bottomLeft)) {
            return 0;
        }
        if (x1 == x2 && y1 == y2) {
            return 1;
        }
        int midx = x1 + x2 >> 1;
        int midy = y1 + y2 >> 1;
        int a = countShips(_sea, _topRight, new int[] {midx + 1, midy + 1});
        int b = countShips(_sea, new int[] {midx, y2}, new int[] {x1, midy + 1});
        int c = countShips(_sea, new int[] {midx, midy}, _bottomLeft);
        int d = countShips(_sea, new int[] {x2, midy}, new int[] {midx + 1, y1});
        return a + b + c + d;
    }

    @SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
    interface Sea {
        boolean hasShips(int[] _topRight, int[] _bottomLeft);
    }

}
