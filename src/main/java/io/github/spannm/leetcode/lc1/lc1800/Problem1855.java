package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1855. Maximum Distance Between a Pair of Values.
 */
class Problem1855 extends LeetcodeProblem {

    int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        for (int i = 0, j = 0; i < m; i++) {
            while (j < n && nums1[i] <= nums2[j]) {
                j++;
            }
            ans = Math.max(ans, j - i - 1);
        }
        return ans;
    }

}
