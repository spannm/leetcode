package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2733. Neither Minimum nor Maximum.
 */
class Problem2733 extends LeetcodeProblem {

    int findNonMinOrMax(int[] nums) {
        int mi = 100;
        int mx = 0;
        for (int x : nums) {
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        for (int x : nums) {
            if (x != mi && x != mx) {
                return x;
            }
        }
        return -1;
    }

}
