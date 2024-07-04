package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem2054 extends LeetcodeProblem {

    int maxTwoEvents(int[][] _events) {
        Arrays.sort(_events, Comparator.comparingInt(a -> a[0]));
        int[] max = new int[_events.length];
        for (int i = _events.length - 1; i >= 0; i--) {
            if (i == _events.length - 1) {
                max[i] = _events[i][2];
            } else {
                max[i] = Math.max(_events[i][2], max[i + 1]);
            }
        }
        int ans = 0;
        for (int i = 0; i < _events.length; i++) {
            int end = _events[i][1];
            int left = i + 1;
            int right = _events.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (_events[mid][0] <= end) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int value = _events[i][2];
            if (right >= 0 && right < _events.length) {
                value += max[right];
            }
            ans = Math.max(ans, value);
        }
        return ans;
    }

}
