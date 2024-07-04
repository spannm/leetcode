package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2918. Minimum Equal Sum of Two Arrays After Replacing Zeros.
 */
class Problem2918 extends LeetcodeProblem {

    long minSum(int[] nums1, int[] nums2) {
        long s1 = 0;
        long s2 = 0;
        boolean hasZero = false;
        for (int x : nums1) {
            hasZero |= x == 0;
            s1 += Math.max(x, 1);
        }
        for (int x : nums2) {
            s2 += Math.max(x, 1);
        }
        if (s1 > s2) {
            return minSum(nums2, nums1);
        }
        if (s1 == s2) {
            return s1;
        }
        return hasZero ? s2 : -1;
    }

}
