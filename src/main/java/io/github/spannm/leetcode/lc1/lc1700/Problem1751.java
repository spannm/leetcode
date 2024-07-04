package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/">1751. Maximum Number of
 * Events That Can Be Attended II</a>.
 */
class Problem1751 extends LeetcodeProblem {

    int maxValue(final int[][] _events, final int _k) {
        int max = 0;
        if (_k == 1) {
            for (int[] event : _events) {
                max = Math.max(max, event[2]);
            }
            return max;
        }

        Arrays.sort(_events, Comparator.comparingInt(a -> a[0]));
        int size = _events.length;

        final int[][] memo = new int[size + 1][_k + 1];

        for (int i = size - 1; i >= 0; i--) {
            int next = binarySearch(_events, _events[i][1], i + 1, size);

            for (int j = 1; j <= _k; j++) {
                memo[i][j] = Math.max(memo[i + 1][j], // current event
                    memo[next][j - 1] + _events[i][2]); // last event + next available event
            }
        }
        return memo[0][_k];
    }

    private static int binarySearch(final int[][] _events, final int _targetEnd, int _low, int _high) {
        while (_low < _high) {
            int mid = (_high - _low) / 2 + _low;
            if (_targetEnd >= _events[mid][0]) {
                _low = mid + 1;
            } else {
                _high = mid;
            }
        }
        return _low;
    }

}
