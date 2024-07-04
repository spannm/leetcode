package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0718 extends LeetcodeProblem {

    int findLength(int[] _nums1, int[] _nums2) {
        int[] shorter = _nums1.length < _nums2.length ? _nums1 : _nums2;
        int[] longer = _nums1.length < _nums2.length ? _nums2 : _nums1;
        int maxLen = 0;
        for (int i = 0; i < shorter.length - 1; i++) {
            for (int j = shorter.length; j >= 0 && j > i && j - i > maxLen; j--) {
                int[] candidate = Arrays.copyOfRange(shorter, i, j);
                if (candidate.length > maxLen && isSubarray(candidate, longer)) {
                    maxLen = candidate.length;
                }
            }
        }
        return maxLen;
    }

    private static boolean isSubarray(int[] _candidate, int[] _array) {
        for (int i = 0; i <= _array.length - _candidate.length; i++) {
            if (Arrays.equals(_candidate, Arrays.copyOfRange(_array, i, i + _candidate.length))) {
                return true;
            }
        }
        return false;
    }

}
