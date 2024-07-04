package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/">1326. Minimum Number of
 * Taps to Open to Water a Garden</a>.
 */
class Problem1326 extends LeetcodeProblem {

    int minTaps(final int _n, int[] _ranges) {
        int[] jumps = new int[_n + 1];
        for (int i = 0; i <= _n; i++) {
            int l = Math.max(0, i - _ranges[i]);
            int r = Math.min(_n, i + _ranges[i]);
            jumps[l] = r - l;
        }

        int bgn = 0;
        int end = 0;
        int cnt = 0;
        while (end < _n) {
            int newEnd = end;
            for (int i = bgn; i <= end; i++) {
                newEnd = Math.max(newEnd, i + jumps[i]);
            }

            if (end == newEnd) {
                return -1;
            }
            bgn = end + 1;
            end = newEnd;
            cnt++;

        }

        _ranges = null;
        jumps = null;
        System.gc();

        return cnt;
    }

}
