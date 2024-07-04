package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1401. Circle and Rectangle Overlapping
 * <p>
 * Given a circle represented as (radius, x_center, y_center) and an axis-aligned rectangle represented as (x1, y1, x2,
 * y2), where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right
 * corner of the rectangle. Return True if the circle and rectangle are overlapped otherwise return False. In other
 * words, check if there are any point (xi, yi) such that belongs to the circle and the rectangle at the same time.
 * <p>
 * Example 1: Input: radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1 Output: true Explanation:
 * Circle and rectangle share the point (1,0)
 * <p>
 * Example 2: Input: radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1 Output: true
 * <p>
 * Example 3: Input: radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3 Output: true
 * <p>
 * Example 4: Input: radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1 Output: false
 * <p>
 * Constraints: 1 <= radius <= 2000 -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4 x1 < x2 y1 < y2
 */
class Problem1401 extends LeetcodeProblem {

    boolean checkOverlap(int _radius, int _xCenter, int _yCenter, int _x1, int _y1, int _x2, int _y2) {
        if (_x1 <= _xCenter && _x2 >= _xCenter && _y1 <= _yCenter && _y2 >= _yCenter) {
            return true;
        }
        int circleDistance = _radius * _radius;
        for (int x = _x1; x <= _x2; x++) {
            if (dist(x, _y1, _xCenter, _yCenter) <= circleDistance) {
                return true;
            }
        }

        for (int x = _x1; x <= _x2; x++) {
            if (dist(x, _y2, _xCenter, _yCenter) <= circleDistance) {
                return true;
            }
        }

        for (int y = _y1; y <= _y2; y++) {
            if (dist(_x1, y, _xCenter, _yCenter) <= circleDistance) {
                return true;
            }
        }

        for (int y = _y1; y <= _y2; y++) {
            if (dist(_x2, y, _xCenter, _yCenter) <= circleDistance) {
                return true;
            }
        }
        return false;
    }

    private int dist(int _x1, int _y1, int _x2, int _y2) {
        return (_x1 - _x2) * (_x1 - _x2) + (_y1 - _y2) * (_y1 - _y2);
    }

}
