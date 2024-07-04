package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2008. Maximum Earnings From Taxi.
 */
class Problem2008 extends LeetcodeProblem {

    long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));
        int m = rides.length;
        long[] f = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            int[] r = rides[i - 1];
            int st = r[0];
            int ed = r[1];
            int tip = r[2];
            int j = search(rides, st + 1, i);
            f[i] = Math.max(f[i - 1], f[j] + ed - st + tip);
        }
        return f[m];
    }

    private int search(int[][] nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid][1] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
