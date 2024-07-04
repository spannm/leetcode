package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1537. Get the Maximum Score.
 */
class Problem1537 extends LeetcodeProblem {

    int maxSum(int[] nums1, int[] nums2) {
        final int mod = (int) 1e9 + 7;
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        long f = 0;
        long g = 0;
        while (i < m || j < n) {
            if (i == m) {
                g += nums2[j++];
            } else if (j == n) {
                f += nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                f += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                g += nums2[j++];
            } else {
                f = g = Math.max(f, g) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(f, g) % mod);
    }

}
