package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/maximum-running-time-of-n-computers/">2141. Maximum Running Time of N
 * Computers</a>.
 */
class Problem2141 extends LeetcodeProblem {

    long maxRunTime(final int _computers, int[] _batteries) {
        final java.util.IntSummaryStatistics stats = java.util.Arrays.stream(_batteries).summaryStatistics();

        final long batteryTotal = stats.getSum();
        long low = stats.getMin();
        long high = batteryTotal / _computers + 1;
        long runTime = 0;

        while (low < high) { // binary search
            long mid = low + (high - low) / 2;
            if (isPossible(_batteries, _computers, mid)) {
                runTime = mid;
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        _batteries = null;
        System.gc();

        return runTime;
    }

    static boolean isPossible(final int[] _batteries, final int _n, final long _target) {
        long total = _n * _target;
        long sum = 0;
        for (int battery : _batteries) {
            if (battery > _target) {
                sum += _target;
            } else {
                sum += battery;
            }

            if (sum >= total) {
                return true;
            }
        }
        return sum >= total;

    }

}
