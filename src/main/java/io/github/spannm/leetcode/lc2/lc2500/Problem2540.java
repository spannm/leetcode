package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2540. Minimum Common Value.
 */
class Problem2540 extends LeetcodeProblem {

    int getCommon(int[] _nums1, int[] _nums2) {
        int len1 = _nums1.length;
        int len2 = _nums2.length;
        if (_nums1[len1 - 1] >= _nums2[0] && _nums2[len2 - 1] >= _nums1[0]) {
            int i = 0;
            int j = 0;
            while (i < len1 && j < len2) {
                if (_nums1[i] == _nums2[j]) {
                    return _nums1[i];
                } else if (_nums1[i] < _nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return -1;
    }

}
