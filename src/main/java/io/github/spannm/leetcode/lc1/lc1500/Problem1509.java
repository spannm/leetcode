package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1509. Minimum Difference Between Largest and Smallest Value in Three Moves.
 */
class Problem1509 extends LeetcodeProblem {

    int minDifference(int[] _nums) {
        int len = _nums.length;
        if (len < 5) {
            return 0;
        }
        Arrays.sort(_nums);
        long result = 1L << 60;
        for (int l = 0; l <= 3; l++) {
            int r = 3 - l;
            result = Math.min(result, (long) _nums[len - 1 - r] - _nums[l]);
        }
        return (int) result;
    }

}
