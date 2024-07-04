package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2968. Apply Operations to Maximize Frequency Score.
 */
class Problem2968 extends LeetcodeProblem {

    int maxFrequencyScore(int[] _nums, long _k) {
        Arrays.sort(_nums);
        int n = _nums.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + _nums[i - 1];
        }
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            boolean ok = false;

            for (int i = 0; i <= n - mid; i++) {
                int j = i + mid;
                int x = _nums[(i + j) / 2];
                long left = ((i + j) / 2 - i) * (long) x - (s[(i + j) / 2] - s[i]);
                long right = s[j] - s[(i + j) / 2] - (j - (i + j) / 2) * (long) x;
                if (left + right <= _k) {
                    ok = true;
                    break;
                }
            }

            if (ok) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

}
