package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 774. Minimize Max Distance to Gas Station.
 */
class Problem0774 extends LeetcodeProblem {

    double minmaxGasDist(int[] _stations, int _k) {
        double left = 0;
        double right = 1e8;
        while (right - left > 1e-6) {
            double mid = (left + right) / 2.0;
            if (check(mid, _stations, _k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean check(double _x, int[] _stations, int _k) {
        int s = 0;
        for (int i = 0; i < _stations.length - 1; i++) {
            s += (int) ((_stations[i + 1] - _stations[i]) / _x);
        }
        return s <= _k;
    }

}
