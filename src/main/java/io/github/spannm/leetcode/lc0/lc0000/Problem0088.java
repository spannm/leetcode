package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0088 extends LeetcodeProblem {

    void merge(int[] _nums1, int _m, int[] _nums2, int _n) {
        int i = _m - 1;
        int j = _n - 1;
        int k = _m + _n - 1;
        while (i >= 0 && j >= 0) {
            if (_nums1[i] > _nums2[j]) {
                _nums1[k--] = _nums1[i--];
            } else {
                _nums1[k--] = _nums2[j--];
            }
        }
        while (j >= 0) {
            _nums1[k--] = _nums2[j--];
        }
    }

}
