package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 871. Minimum Number of Refueling Stops.
 */
class Problem0871 extends LeetcodeProblem {

    int minRefuelStops(int _target, int _startFuel, int[][] _stations) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = _stations.length;
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            int d = (i < n ? _stations[i][0] : _target) - prev;
            _startFuel -= d;
            while (_startFuel < 0 && !q.isEmpty()) {
                _startFuel += q.poll();
                ans++;
            }
            if (_startFuel < 0) {
                return -1;
            }
            if (i < n) {
                q.offer(_stations[i][1]);
                prev = _stations[i][0];
            }
        }
        return ans;
    }

}
