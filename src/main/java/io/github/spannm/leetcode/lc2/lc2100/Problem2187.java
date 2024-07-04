package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-complete-trips/">2187. Minimum Time to Complete Trips</a>.
 */
class Problem2187 extends LeetcodeProblem {

    long minimumTimeBruteForce(int[] _time, int _totalTrips) {
        for (int currTime = 1;; currTime++) {
            int tripCount = 0;
            for (int element : _time) {
                tripCount += currTime / element;
            }
            if (tripCount >= _totalTrips) {
                return currTime;
            }
        }
    }

    long minimumTime(int[] _time, int _totalTrips) {
        if (_time.length == 1) {
            return _time[0] * (long) _totalTrips;
        }
        long min = Integer.MAX_VALUE;
        for (int it : _time) {
            if (min > it) {
                min = it;
            }
        }
        long low = min;
        long high = _totalTrips * min;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (isValidTime(mid, _totalTrips, _time)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isValidTime(long _timeToCheck, int _totalTrips, int[] _times) {
        long trips = 0;
        for (int time : _times) {
            trips += _timeToCheck / time;
        }
        return trips >= _totalTrips;
    }

}
