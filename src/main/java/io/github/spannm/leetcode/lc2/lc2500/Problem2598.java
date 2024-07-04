package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2598. Smallest Missing Non-negative Integer After Operations.
 */
class Problem2598 extends LeetcodeProblem {

    int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for (int x : nums) {
            ++cnt[(x % value + value) % value];
        }
        for (int i = 0;; i++) {
            if (cnt[i % value]-- == 0) {
                return i;
            }
        }
    }

}
