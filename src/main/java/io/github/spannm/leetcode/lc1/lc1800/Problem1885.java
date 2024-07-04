package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1885. Count Pairs in Two Arrays.
 */
class Problem1885 extends LeetcodeProblem {

    long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(d);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n;
            while (left < right) {
                int mid = left + right >> 1;
                if (d[mid] > -d[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans += n - left;
        }
        return ans;
    }

}
