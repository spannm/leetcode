package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0321 extends LeetcodeProblem {

    int[] maxNumber(int[] _nums1, int[] _nums2, int _k) {
        int len1 = _nums1.length;
        int len2 = _nums2.length;
        int[] ans = new int[_k];
        for (int i = Math.max(0, _k - len2); i <= _k && i <= len1; i++) {

            int[] candidate = merge(maxArray(_nums1, i), maxArray(_nums2, _k - i), _k);
            if (greater(candidate, 0, ans, 0)) {
                ans = candidate;
            }
        }
        return ans;
    }

    static boolean greater(int[] _nums1, int _i1, int[] _nums2, int _i2) {
        while (_i1 < _nums1.length && _i2 < _nums2.length && _nums1[_i1] == _nums2[_i2]) {
            _i1++;
            _i2++;
        }
        return _i2 == _nums2.length || _i1 < _nums1.length && _nums1[_i1] > _nums2[_i2];
    }

    static int[] merge(int[] _nums1, int[] _nums2, int _k) {
        int[] ans = new int[_k];
        for (int i = 0, j = 0, r = 0; r < _k; r++) {
            ans[r] = greater(_nums1, i, _nums2, j) ? _nums1[i++] : _nums2[j++];
        }
        return ans;
    }

    static int[] maxArray(int[] _nums, int _k) {
        int len = _nums.length;
        int[] ans = new int[_k];
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i + j > _k && j > 0 && ans[j - 1] < _nums[i]) {
                j--;
            }
            if (j < _k) {
                ans[j++] = _nums[i];
            }
        }
        return ans;
    }

}
