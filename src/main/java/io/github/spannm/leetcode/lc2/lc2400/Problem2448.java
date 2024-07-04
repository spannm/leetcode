package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-make-array-equal/">2448. Minimum Cost to Make Array Equal</a>.
 */
class Problem2448 extends LeetcodeProblem {

    final long minCost(final int[] _nums, final int[] _cost) {
        int l = 0;
        int r = 1000000;

        while (l <= r) {
            final int mid = (l + r) / 2;
            final long p1 = calcCost(mid - 1, _nums, _cost);
            final long p2 = calcCost(mid, _nums, _cost);
            if (p1 >= p2) {
                final long p3 = calcCost(mid + 1, _nums, _cost);
                if (p3 >= p2) {
                    return p2;
                }
            }
            if (p1 < p2) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return 0;
    }

    static long calcCost(int _mid, int[] _arr, int[] _cost) {
        return IntStream.range(0, _arr.length).mapToLong(i -> Math.abs(_mid - _arr[i]) * (long) _cost[i]).sum();
    }

}
