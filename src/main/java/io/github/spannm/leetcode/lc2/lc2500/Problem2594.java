package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2594. Minimum Time to Repair Cars.
 */
class Problem2594 extends LeetcodeProblem {

    long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = 1L * ranks[0] * cars * cars;
        while (left < right) {
            long mid = left + right >> 1;
            long cnt = 0;
            for (int r : ranks) {
                cnt += Math.sqrt(mid / r);
            }
            if (cnt >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
