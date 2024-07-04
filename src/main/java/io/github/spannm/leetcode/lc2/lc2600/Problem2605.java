package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2605. Form Smallest Number From Two Digit Arrays.
 */
class Problem2605 extends LeetcodeProblem {

    int minNumber(int[] nums1, int[] nums2) {
        int mask1 = 0;
        int mask2 = 0;
        for (int x : nums1) {
            mask1 |= 1 << x;
        }
        for (int x : nums2) {
            mask2 |= 1 << x;
        }
        int mask = mask1 & mask2;
        if (mask != 0) {
            return Integer.numberOfTrailingZeros(mask);
        }
        int a = Integer.numberOfTrailingZeros(mask1);
        int b = Integer.numberOfTrailingZeros(mask2);
        return Math.min(a * 10 + b, b * 10 + a);
    }

}
