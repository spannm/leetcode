package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1064. Fixed Point.
 */
class Problem1064 extends LeetcodeProblem {

    int fixedPoint(int[] _arr) {
        int left = 0;
        int right = _arr.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (_arr[mid] >= mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return _arr[left] == left ? left : -1;
    }

}
