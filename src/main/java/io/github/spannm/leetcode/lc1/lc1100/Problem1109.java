package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1109. Corporate Flight Bookings.
 */
class Problem1109 extends LeetcodeProblem {

    int[] corpFlightBookings(int[][] _bookings, int _n) {
        int[] ans = new int[_n];
        for (int[] b : _bookings) {
            int first = b[0];
            int last = b[1];
            int seats = b[2];
            ans[first - 1] += seats;
            if (last < _n) {
                ans[last] -= seats;
            }
        }
        for (int i = 1; i < _n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }

}
