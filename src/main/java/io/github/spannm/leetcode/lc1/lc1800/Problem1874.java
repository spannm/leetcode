package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1874 extends LeetcodeProblem {

    int minProductSum(int[] _nums1, int[] _nums2) {
        Arrays.sort(_nums1);
        Arrays.sort(_nums2);
        int ans = 0;
        for (int i = 0, j = _nums1.length - 1; i < _nums1.length && j >= 0; i++, j--) {
            ans += _nums1[i] * _nums2[j];
        }
        return ans;
    }

}
