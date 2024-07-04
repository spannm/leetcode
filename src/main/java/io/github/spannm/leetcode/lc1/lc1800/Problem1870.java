package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/">1870. Minimum Speed to Arrive on
 * Time</a>.
 */
class Problem1870 extends LeetcodeProblem {

    int minSpeedOnTime(int[] _dist, final double _hour) {
        int l = 0;
        int r = 10000000;
        int minSpeed = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            double val = check(_dist, mid);

            if (val <= _hour) {
                minSpeed = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        _dist = null;
        System.gc();

        return minSpeed;
    }

    static double check(int[] _dist, int _speed) {
        if (_speed == 0) {
            return Double.MAX_VALUE;
        }

        double time = 0.0;

        final int count = _dist.length;

        for (int i = 0; i < count; i++) {
            double t = _dist[i] / (double) _speed;
            if (count - 1 == i) {
                time += t;
            } else {
                time += Math.ceil(t);
            }
        }

        return time;
    }

}
