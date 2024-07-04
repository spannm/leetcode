package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2580. Count Ways to Group Overlapping Ranges.
 */
class Problem2580 extends LeetcodeProblem {

    int countWays(int[][] ranges) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));
        int cnt = 0;
        int mx = -1;
        for (int[] e : ranges) {
            if (e[0] > mx) {
                cnt++;
            }
            mx = Math.max(mx, e[1]);
        }
        return qpow(2, cnt, (int) 1e9 + 7);
    }

    private int qpow(long a, int n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }

}
