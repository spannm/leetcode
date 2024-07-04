package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0354 extends LeetcodeProblem {

    int maxEnvelopes(int[][] _envelopes) {
        if (_envelopes == null || _envelopes.length == 0 || _envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(_envelopes, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[_envelopes.length];
        int len = 0;
        for (int[] envelope : _envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }

}
