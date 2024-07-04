package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 853. Car Fleet.
 */
class Problem0853 extends LeetcodeProblem {

    int carFleet(int _target, int[] _position, int[] _speed) {
        int n = _position.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> _position[j] - _position[i]);
        int ans = 0;
        double pre = 0;
        for (int i : idx) {
            double t = 1.0 * (_target - _position[i]) / _speed[i];
            if (t > pre) {
                ans++;
                pre = t;
            }
        }
        return ans;
    }

}
