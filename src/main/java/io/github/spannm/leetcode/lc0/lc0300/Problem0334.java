package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 334. Increasing Triplet Subsequence.
 */
class Problem0334 extends LeetcodeProblem {

    boolean increasingTriplet(int[] _nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : _nums) {
            if (num > mid) {
                return true;
            } else if (num <= min) {
                min = num;
            } else {
                mid = num;
            }
        }
        return false;
    }

}
