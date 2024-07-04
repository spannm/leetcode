package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/max-points-on-a-line/">149. Max Points on a Line</a>.
 */
class Problem0149 extends LeetcodeProblem {

    int maxPoints(int[][] _points) {
        if (_points.length < 3) {
            return _points.length;
        }
        int max = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < _points.length; i++) {
            int dup = 1;
            map.clear();
            for (int j = i + 1; j < _points.length; j++) {
                int dx = _points[j][0] - _points[i][0];
                int dy = _points[j][1] - _points[i][1];
                if (dx == 0 && dy == 0) {
                    dup++;
                } else {
                    int gcd = getGcd(dx, dy);
                    long slope = ((long) (dy / gcd) << 32) + dx / gcd;
                    map.compute(slope, (k, v) -> v == null ? 1 : v + 1);
                }
            }
            max = Math.max(max, dup);
            for (Integer val : map.values()) {
                max = Math.max(max, val + dup);
            }
        }
        return max;
    }

    static int getGcd(int _a, int _b) {
        return _b == 0 ? _a : getGcd(_b, _a % _b);
    }

}
