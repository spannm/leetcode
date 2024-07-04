package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

class Problem0469 extends LeetcodeProblem {

    boolean isConvex(List<List<Integer>> _points) {
        boolean gotNegative = false;
        boolean gotPositive = false;
        int numPoints = _points.size();
        int b;
        int c;
        for (int a = 0; a < numPoints; a++) {

            b = (a + 1) % numPoints;
            c = (b + 1) % numPoints;

            int crossProduct =
                crossProductLength(
                    _points.get(a).get(0), _points.get(a).get(1),
                    _points.get(b).get(0), _points.get(b).get(1),
                    _points.get(c).get(0), _points.get(c).get(1));
            if (crossProduct < 0) {
                gotNegative = true;
            } else if (crossProduct > 0) {
                gotPositive = true;
            }
            if (gotNegative && gotPositive) {
                return false;
            }
        }

        return true;
    }

    private int crossProductLength(int _ax, int _ay, int _bx, int _by, int _cx, int _cy) {

        int bax = _ax - _bx;
        int bay = _ay - _by;
        int bcx = _cx - _bx;
        int bcy = _cy - _by;

        return bax * bcy - bay * bcx;
    }

}
