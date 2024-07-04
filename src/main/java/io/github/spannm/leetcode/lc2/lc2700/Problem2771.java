package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2771. Longest Non-decreasing Subarray From Two Arrays.
 */
class Problem2771 extends LeetcodeProblem {

    int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int f = 1;
        int g = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int ff = 1;
            int gg = 1;
            if (nums1[i] >= nums1[i - 1]) {
                ff = Math.max(ff, f + 1);
            }
            if (nums1[i] >= nums2[i - 1]) {
                ff = Math.max(ff, g + 1);
            }
            if (nums2[i] >= nums1[i - 1]) {
                gg = Math.max(gg, f + 1);
            }
            if (nums2[i] >= nums2[i - 1]) {
                gg = Math.max(gg, g + 1);
            }
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

}
