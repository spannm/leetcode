package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1997. First Day Where You Have Been in All the Rooms.
 */
class Problem1997 extends LeetcodeProblem {

    int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] f = new long[n];
        final int mod = (int) 1e9 + 7;
        for (int i = 1; i < n; i++) {
            f[i] = (f[i - 1] + 1 + f[i - 1] - f[nextVisit[i - 1]] + 1 + mod) % mod;
        }
        return (int) f[n - 1];
    }

}
