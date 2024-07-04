package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/moving-stones-until-consecutive-ii/">1040. Moving Stones Until Consecutive
 * II.</a>.
 */
class Problem1040 extends LeetcodeProblem {

    int[] numMovesStonesII(int[] _stones) {
        Arrays.sort(_stones);
        int n = _stones.length;
        int mi = n;
        int mx = Math.max(_stones[n - 1] - _stones[1] + 1, _stones[n - 2] - _stones[0] + 1) - (n - 1);
        for (int i = 0, j = 0; j < n; j++) {
            while (_stones[j] - _stones[i] + 1 > n) {
                i++;
            }
            if (j - i + 1 == n - 1 && _stones[j] - _stones[i] == n - 2) {
                mi = Math.min(mi, 2);
            } else {
                mi = Math.min(mi, n - (j - i + 1));
            }
        }
        return new int[] {mi, mx};
    }

}
