package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2425. Bitwise XOR of All Pairings.
 */
class Problem2425 extends LeetcodeProblem {

    int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums2.length % 2 == 1) {
            for (int v : nums1) {
                ans ^= v;
            }
        }
        if (nums1.length % 2 == 1) {
            for (int v : nums2) {
                ans ^= v;
            }
        }
        return ans;
    }

}
