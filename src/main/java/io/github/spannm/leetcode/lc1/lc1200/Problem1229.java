package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1229. Meeting Scheduler.
 */
class Problem1229 extends LeetcodeProblem {

    List<Integer> minAvailableDuration(int[][] _slots1, int[][] _slots2, int _duration) {
        Arrays.sort(_slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(_slots2, Comparator.comparingInt(a -> a[0]));
        int m = _slots1.length;
        int n = _slots2.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int start = Math.max(_slots1[i][0], _slots2[j][0]);
            int end = Math.min(_slots1[i][1], _slots2[j][1]);
            if (end - start >= _duration) {
                return Arrays.asList(start, start + _duration);
            }
            if (_slots1[i][1] < _slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return List.of();
    }

}
