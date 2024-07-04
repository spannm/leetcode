package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 801. Minimum Swaps To Make Sequences Increasing.
 */
class Problem0801 extends LeetcodeProblem {

    int minSwap(int[] _nums1, int[] _nums2) {
        int a = 0;
        int b = 1;
        for (int i = 1; i < _nums1.length; i++) {
            int x = a;
            int y = b;
            if (_nums1[i - 1] >= _nums1[i] || _nums2[i - 1] >= _nums2[i]) {
                a = y;
                b = x + 1;
            } else {
                b = y + 1;
                if (_nums1[i - 1] < _nums2[i] && _nums2[i - 1] < _nums1[i]) {
                    a = Math.min(a, y);
                    b = Math.min(b, x + 1);
                }
            }
        }
        return Math.min(a, b);
    }

}
